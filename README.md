# ffmpeg-scale

<details>
  <summary>test.sh</summary>

```
# Run using below command for different resolutions (generates resolution specific logs)
# parallel -j1 -k ./test.sh {1} '>>' {1}.log ::: {144,240,360} 

mkdir -p $1

{ { for file in *.mp4;
do
echo
echo $file" Output_Resolution : "$1"p"

echo
echo "Method : Whole "
time `java -jar test.jar $file $1 $1/whole_$file.m3u8`

echo

for j in 15 30 60;
do
echo "Method : Segmentation, Segment_Size : "$j"s"
mkdir -p $1_$j
time `java -jar test.jar $file $1 $1_$j/seg_$file.m3u8 $j`
echo
done;

done; }  2>&1; }
```
</details>