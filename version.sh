#! /bin/bash 
filename="project-version.properties"
 if [ -e "$filename" ]; then 
    content=$(cat "$filename") 
    echo "initial version $content"
else 
    echo "File not found: $filename" 
fi

# Build array from version string.
a=( ${content//./ } )
((a[1]++))
a[2]=0

newVersion="${a[0]}.${a[1]}.${a[2]}"
echo "new version $newVersion"
echo $newVersion > project-version.properties

git commit -am "[CHORE] Increment version to $newVersion"
git push origin mutation-testing

git tag $newVersion
git push origin $newVersion
