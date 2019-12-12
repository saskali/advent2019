#!/bin/bash

set -eux

DEST="$1"
PART1="$2"
PART2="$3"
WIDTH=600

SVG="${DEST}_diff.svg"

git diff --word-diff=color --diff-algorithm=minimal --no-index "$PART1" "$PART2" \
  | ansifilter -S --width $WIDTH --height __HEIGHT__ \
  > "${SVG}"

HEIGHT=$(grep -o 'y=\"[0-9]*\"' "${SVG}" | tail -1 | grep -o '[0-9]\+')
HEIGHT=$((HEIGHT + 20))

sed "s/__HEIGHT__/${HEIGHT}/g" "${SVG}" > "${SVG}.tmp"
mv "${SVG}.tmp" "${SVG}"

echo "## ${DEST}" >> README.md
echo "![${DEST}](./${SVG})" >> README.md
