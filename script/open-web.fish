#!/usr/bin/env fish

function open_web
  argparse -n open_web 'h/help' 'u/url=' -- $argv
  or return 1

  if set -lq _flag_help
    echo "run-docker.fish -u/--url <TARGET>"
    return
  end

  set -lq _flag_url
  or set -l _flag_url "swagger-ui.html"

  open http://localhost:8080/$_flag_url
end

open_web $argv
