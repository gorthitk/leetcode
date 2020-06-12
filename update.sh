#!/usr/bin/env bash

rm -rf README.md
echo "# leetcode" >> README.md
echo "My Solutions to leetcode problems" >> README.md

# Render the table

echo "<table><thead><tr><th>Question</th> <th>Link to solution to</th></tr></thead><tbody>" >> README.md

for entry in *
do
    if [[ "$entry" =~ ^Problem.* ]]; then
        ID=$entry
        prefix="### Problem "
        line=$(head -n 1 $entry/README.md)

        echo "<tr>" >> README.md
        echo "<td> ${line#$prefix} </td>"  >> README.md
        echo "<td> https://github.com/jetsasank/leetcode/tree/master/$entry </td>"  >> README.md
        echo "</tr>" >> README.md
    fi
done

echo "</tbody></table>"  >> README.md