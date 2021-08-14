#!/bin/bash

echo "$(tput setaf 2)REMOVING VOLUME...$(tput sgr 0)"
docker volume rm flight-app
echo