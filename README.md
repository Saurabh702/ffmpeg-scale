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
time `java -jar test.jar $file $1 $1/whole_$file`

echo

for j in 15 30 60;
do
echo "Method : Segmentation, Segment_Size : "$j"s"
mkdir -p $1_$j
time `java -jar test.jar $file $1 $1_$j/seg_$file $j`
echo
done;

done; }  2>&1; }
```
</details>

## Logs

* Windows 10 Single Edition v1903
  * Terminal : git-bash
  * java version : 1.8.0_171
  * ffmpeg version : git-2020-03-03-60b1f85
  * GNU parallel version : 20200322
  * Time taken for benchmark : ~4348s
  * Storage : HDD
  
  ### Visualization
  
  **Duration of Videos in order** : 128.53s, 364.57s, 91.75s, 264.23s, 202.73s
  
<details>
  <summary>144.log</summary>
  
```

20005819.mp4 Output_Resolution : 144p

Method : Whole 

real	0m28.025s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 15s

real	0m22.617s
user	0m0.015s
sys	0m0.031s

Method : Segmentation, Segment_Size : 30s

real	0m21.708s
user	0m0.031s
sys	0m0.015s

Method : Segmentation, Segment_Size : 60s

real	0m21.290s
user	0m0.000s
sys	0m0.062s


20005821.mp4 Output_Resolution : 144p

Method : Whole 

real	1m22.475s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 15s

real	1m11.150s
user	0m0.015s
sys	0m0.031s

Method : Segmentation, Segment_Size : 30s

real	1m10.665s
user	0m0.015s
sys	0m0.062s

Method : Segmentation, Segment_Size : 60s

real	1m8.720s
user	0m0.031s
sys	0m0.046s


20005847.mp4 Output_Resolution : 144p

Method : Whole 

real	0m17.620s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 15s

real	0m16.005s
user	0m0.000s
sys	0m0.046s

Method : Segmentation, Segment_Size : 30s

real	0m16.194s
user	0m0.015s
sys	0m0.031s

Method : Segmentation, Segment_Size : 60s

real	0m16.451s
user	0m0.015s
sys	0m0.046s


20005849.mp4 Output_Resolution : 144p

Method : Whole 

real	0m53.103s
user	0m0.015s
sys	0m0.046s

Method : Segmentation, Segment_Size : 15s

real	0m45.690s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 30s

real	0m34.404s
user	0m0.000s
sys	0m0.078s

Method : Segmentation, Segment_Size : 60s

real	0m33.410s
user	0m0.000s
sys	0m0.046s


20005850.mp4 Output_Resolution : 144p

Method : Whole 

real	0m35.355s
user	0m0.015s
sys	0m0.062s

Method : Segmentation, Segment_Size : 15s

real	0m30.640s
user	0m0.031s
sys	0m0.046s

Method : Segmentation, Segment_Size : 30s

real	0m29.128s
user	0m0.000s
sys	0m0.046s

Method : Segmentation, Segment_Size : 60s

real	0m28.468s
user	0m0.031s
sys	0m0.046s


```
</details>

![144](https://user-images.githubusercontent.com/29001233/79412736-d6f5ba80-7fc3-11ea-871b-c9b62de46ac3.png)
  
<details>
  <summary>240.log</summary>
  
```  

20005819.mp4 Output_Resolution : 240p

Method : Whole 

real	0m42.801s
user	0m0.015s
sys	0m0.046s

Method : Segmentation, Segment_Size : 15s

real	0m40.166s
user	0m0.015s
sys	0m0.046s

Method : Segmentation, Segment_Size : 30s

real	0m41.369s
user	0m0.000s
sys	0m0.031s

Method : Segmentation, Segment_Size : 60s

real	0m39.594s
user	0m0.000s
sys	0m0.046s


20005821.mp4 Output_Resolution : 240p

Method : Whole 

real	2m18.977s
user	0m0.000s
sys	0m0.046s

Method : Segmentation, Segment_Size : 15s

real	2m9.710s
user	0m0.031s
sys	0m0.015s

Method : Segmentation, Segment_Size : 30s

real	2m6.590s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 60s

real	2m7.726s
user	0m0.031s
sys	0m0.046s


20005847.mp4 Output_Resolution : 240p

Method : Whole 

real	0m29.161s
user	0m0.000s
sys	0m0.078s

Method : Segmentation, Segment_Size : 15s

real	0m28.147s
user	0m0.015s
sys	0m0.062s

Method : Segmentation, Segment_Size : 30s

real	0m27.060s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 60s

real	0m26.838s
user	0m0.000s
sys	0m0.062s


20005849.mp4 Output_Resolution : 240p

Method : Whole 

real	1m11.594s
user	0m0.015s
sys	0m0.046s

Method : Segmentation, Segment_Size : 15s

real	1m0.937s
user	0m0.031s
sys	0m0.015s

Method : Segmentation, Segment_Size : 30s

real	0m59.956s
user	0m0.031s
sys	0m0.015s

Method : Segmentation, Segment_Size : 60s

real	0m58.894s
user	0m0.015s
sys	0m0.078s


20005850.mp4 Output_Resolution : 240p

Method : Whole 

real	0m55.496s
user	0m0.031s
sys	0m0.015s

Method : Segmentation, Segment_Size : 15s

real	0m53.499s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 30s

real	0m52.830s
user	0m0.031s
sys	0m0.046s

Method : Segmentation, Segment_Size : 60s

real	0m51.792s
user	0m0.015s
sys	0m0.078s


```
</details>

![240](https://user-images.githubusercontent.com/29001233/79413050-8e8acc80-7fc4-11ea-8148-c4114afd397b.png)

<details>
  <summary>360.log</summary>
  
```

20005819.mp4 Output_Resolution : 360p

Method : Whole 

real	1m18.910s
user	0m0.015s
sys	0m0.046s

Method : Segmentation, Segment_Size : 15s

real	1m15.734s
user	0m0.015s
sys	0m0.046s

Method : Segmentation, Segment_Size : 30s

real	1m14.531s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 60s

real	1m13.810s
user	0m0.015s
sys	0m0.062s


20005821.mp4 Output_Resolution : 360p

Method : Whole 

real	4m12.330s
user	0m0.015s
sys	0m0.046s

Method : Segmentation, Segment_Size : 15s

real	4m2.444s
user	0m0.015s
sys	0m0.062s

Method : Segmentation, Segment_Size : 30s

real	4m2.401s
user	0m0.015s
sys	0m0.062s

Method : Segmentation, Segment_Size : 60s

real	3m58.618s
user	0m0.000s
sys	0m0.078s


20005847.mp4 Output_Resolution : 360p

Method : Whole 

real	0m53.351s
user	0m0.000s
sys	0m0.046s

Method : Segmentation, Segment_Size : 15s

real	0m51.684s
user	0m0.000s
sys	0m0.078s

Method : Segmentation, Segment_Size : 30s

real	0m50.119s
user	0m0.031s
sys	0m0.046s

Method : Segmentation, Segment_Size : 60s

real	0m49.619s
user	0m0.000s
sys	0m0.062s


20005849.mp4 Output_Resolution : 360p

Method : Whole 

real	2m0.711s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 15s

real	1m52.542s
user	0m0.062s
sys	0m0.015s

Method : Segmentation, Segment_Size : 30s

real	1m50.179s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 60s

real	1m49.345s
user	0m0.031s
sys	0m0.046s


20005850.mp4 Output_Resolution : 360p

Method : Whole 

real	1m41.537s
user	0m0.031s
sys	0m0.031s

Method : Segmentation, Segment_Size : 15s

real	1m41.887s
user	0m0.031s
sys	0m0.015s

Method : Segmentation, Segment_Size : 30s

real	1m38.763s
user	0m0.015s
sys	0m0.062s

Method : Segmentation, Segment_Size : 60s

real	1m37.061s
user	0m0.000s
sys	0m0.046s


```
</details>

![360](https://user-images.githubusercontent.com/29001233/79413053-8fbbf980-7fc4-11ea-88cb-af7871598c98.png)

* Ubuntu 18.04.4 LTS
  * Terminal : bash
  * java version : openjdk 11.0.6 2020-01-14
  * ffmpeg version : 3.4.6-0ubuntu0.18.04.1
  * GNU parallel version : 20161222
  * Time taken for benchmark : ~2417s
  * Storage : ramdisk
  
  ### Visualization
  
  **Duration of Videos in order** : 128.53s, 364.57s, 91.75s, 264.23s, 202.73s

<details>
  <summary>144.log</summary>
  
```

20005819.mp4 Output_Resolution : 144p

Method : Whole 

real	0m17.097s
user	0m37.488s
sys	0m0.484s

Method : Segmentation, Segment_Size : 15s

real	0m10.779s
user	0m36.174s
sys	0m0.940s

Method : Segmentation, Segment_Size : 30s

real	0m9.584s
user	0m34.380s
sys	0m0.730s

Method : Segmentation, Segment_Size : 60s

real	0m9.904s
user	0m34.597s
sys	0m0.734s


20005821.mp4 Output_Resolution : 144p

Method : Whole 

real	0m49.420s
user	2m9.382s
sys	0m1.702s

Method : Segmentation, Segment_Size : 15s

real	0m43.306s
user	2m25.505s
sys	0m3.339s

Method : Segmentation, Segment_Size : 30s

real	0m37.960s
user	2m19.940s
sys	0m2.512s

Method : Segmentation, Segment_Size : 60s

real	0m36.584s
user	2m14.725s
sys	0m2.155s


20005847.mp4 Output_Resolution : 144p

Method : Whole 

real	0m11.414s
user	0m28.672s
sys	0m0.437s

Method : Segmentation, Segment_Size : 15s

real	0m7.442s
user	0m26.873s
sys	0m0.772s

Method : Segmentation, Segment_Size : 30s

real	0m8.179s
user	0m29.711s
sys	0m0.729s

Method : Segmentation, Segment_Size : 60s

real	0m8.024s
user	0m27.780s
sys	0m0.610s


20005849.mp4 Output_Resolution : 144p

Method : Whole 

real	0m36.883s
user	1m14.241s
sys	0m0.948s

Method : Segmentation, Segment_Size : 15s

real	0m18.650s
user	1m7.783s
sys	0m1.735s

Method : Segmentation, Segment_Size : 30s

real	0m18.807s
user	1m9.420s
sys	0m1.333s

Method : Segmentation, Segment_Size : 60s

real	0m17.833s
user	1m6.109s
sys	0m1.153s


20005850.mp4 Output_Resolution : 144p

Method : Whole 

real	0m22.288s
user	0m54.689s
sys	0m0.803s

Method : Segmentation, Segment_Size : 15s

real	0m15.852s
user	0m57.920s
sys	0m1.569s

Method : Segmentation, Segment_Size : 30s

real	0m14.102s
user	0m52.053s
sys	0m1.025s

Method : Segmentation, Segment_Size : 60s

real	0m14.244s
user	0m53.406s
sys	0m0.914s


```
</details>

![144](https://user-images.githubusercontent.com/29001233/79422568-a8201a00-7fac-11ea-9c61-1d7501373d72.png)

<details>
  <summary>240.log</summary>

```

20005819.mp4 Output_Resolution : 240p

Method : Whole 

real	0m26.325s
user	1m21.077s
sys	0m0.746s

Method : Segmentation, Segment_Size : 15s

real	0m22.326s
user	1m24.050s
sys	0m1.346s

Method : Segmentation, Segment_Size : 30s

real	0m21.535s
user	1m21.862s
sys	0m1.064s

Method : Segmentation, Segment_Size : 60s

real	0m20.925s
user	1m19.778s
sys	0m0.936s


20005821.mp4 Output_Resolution : 240p

Method : Whole 

real	1m14.470s
user	4m7.713s
sys	0m2.156s

Method : Segmentation, Segment_Size : 15s

real	1m10.606s
user	4m30.286s
sys	0m3.991s

Method : Segmentation, Segment_Size : 30s

real	1m9.422s
user	4m27.229s
sys	0m3.202s

Method : Segmentation, Segment_Size : 60s

real	1m7.883s
user	4m19.260s
sys	0m2.489s


20005847.mp4 Output_Resolution : 240p

Method : Whole 

real	0m16.577s
user	0m53.369s
sys	0m0.419s

Method : Segmentation, Segment_Size : 15s

real	0m14.946s
user	0m55.977s
sys	0m1.031s

Method : Segmentation, Segment_Size : 30s

real	0m15.072s
user	0m56.780s
sys	0m0.786s

Method : Segmentation, Segment_Size : 60s

real	0m14.585s
user	0m54.631s
sys	0m0.612s


20005849.mp4 Output_Resolution : 240p

Method : Whole 

real	0m47.747s
user	2m4.408s
sys	0m1.225s

Method : Segmentation, Segment_Size : 15s

real	0m32.977s
user	2m3.931s
sys	0m2.426s

Method : Segmentation, Segment_Size : 30s

real	0m32.936s
user	2m4.634s
sys	0m1.920s

Method : Segmentation, Segment_Size : 60s

real	0m32.192s
user	2m2.444s
sys	0m1.635s


20005850.mp4 Output_Resolution : 240p

Method : Whole 

real	0m31.811s
user	1m40.016s
sys	0m0.968s

Method : Segmentation, Segment_Size : 15s

real	0m29.226s
user	1m49.657s
sys	0m2.105s

Method : Segmentation, Segment_Size : 30s

real	0m25.728s
user	1m38.038s
sys	0m1.411s

Method : Segmentation, Segment_Size : 60s

real	0m28.913s
user	1m50.316s
sys	0m1.318s


```
</details>

![240](https://user-images.githubusercontent.com/29001233/79422582-ac4c3780-7fac-11ea-9fc3-47ccb9f014fc.png)

<details>
  <summary>360.log</summary>

```

20005819.mp4 Output_Resolution : 360p

Method : Whole 

real	0m43.021s
user	2m30.901s
sys	0m0.833s

Method : Segmentation, Segment_Size : 15s

real	0m41.749s
user	2m40.215s
sys	0m1.734s

Method : Segmentation, Segment_Size : 30s

real	0m40.349s
user	2m29.856s
sys	0m1.327s

Method : Segmentation, Segment_Size : 60s

real	0m41.562s
user	2m40.423s
sys	0m1.270s


20005821.mp4 Output_Resolution : 360p

Method : Whole 

real	2m16.923s
user	8m19.104s
sys	0m3.117s

Method : Segmentation, Segment_Size : 15s

real	2m16.794s
user	8m47.172s
sys	0m5.229s

Method : Segmentation, Segment_Size : 30s

real	2m16.759s
user	8m47.670s
sys	0m4.150s

Method : Segmentation, Segment_Size : 60s

real	2m12.955s
user	8m38.320s
sys	0m3.506s


20005847.mp4 Output_Resolution : 360p

Method : Whole 

real	0m29.632s
user	1m47.598s
sys	0m0.625s

Method : Segmentation, Segment_Size : 15s

real	0m28.936s
user	1m48.836s
sys	0m1.425s

Method : Segmentation, Segment_Size : 30s

real	0m29.091s
user	1m48.431s
sys	0m1.094s

Method : Segmentation, Segment_Size : 60s

real	0m27.792s
user	1m46.473s
sys	0m0.791s


20005849.mp4 Output_Resolution : 360p

Method : Whole 

real	1m16.348s
user	4m0.150s
sys	0m1.583s

Method : Segmentation, Segment_Size : 15s

real	1m3.471s
user	4m2.375s
sys	0m3.419s

Method : Segmentation, Segment_Size : 30s

real	0m59.859s
user	3m50.284s
sys	0m2.481s

Method : Segmentation, Segment_Size : 60s

real	0m59.510s
user	3m49.646s
sys	0m1.928s


20005850.mp4 Output_Resolution : 360p

Method : Whole 

real	1m0.954s
user	3m36.698s
sys	0m1.294s

Method : Segmentation, Segment_Size : 15s

real	0m59.127s
user	3m34.739s
sys	0m2.395s

Method : Segmentation, Segment_Size : 30s

real	0m52.250s
user	3m21.775s
sys	0m1.839s

Method : Segmentation, Segment_Size : 60s

real	0m55.334s
user	3m33.898s
sys	0m1.783s


```
</details>


![360](https://user-images.githubusercontent.com/29001233/79422584-ad7d6480-7fac-11ea-8e39-b5a45aaddf97.png)
