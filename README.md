# Spatial Hotspot Analysis using Apache Sedona

## Requirement
In this project, we are required to do spatial hotspot analysis. In particular, we need to complete two different hotspot analysis tasks 

### Hot zone analysis
This task will needs to perform a range join operation on a rectangle datasets and a point dataset. For each rectangle, the number of points located within the rectangle will be obtained. The hotter rectangle means that it include more points. So this task is to calculate the hotness of all the rectangles. 

### Hot cell analysis

#### Description
This task will focus on applying spatial statistics to spatio-temporal big data in order to identify statistically significant spatial hot spots using Apache Spark. The topic of this task is from ACM SIGSPATIAL GISCUP 2016.

The Problem Definition page is here: [http://sigspatial2016.sigspatial.org/giscup2016/problem](http://sigspatial2016.sigspatial.org/giscup2016/problem) 

The Submit Format page is here: [http://sigspatial2016.sigspatial.org/giscup2016/submit](http://sigspatial2016.sigspatial.org/giscup2016/submit)


## Coding template specification

### Input parameters

1. Output path (Mandatory)
2. Task name: "hotzoneanalysis" or "hotcellanalysis"
3. Task parameters: (1) Hot zone (2 parameters): nyc taxi data path, zone path(2) Hot cell (1 parameter): nyc taxi data path

Example
```
test/output hotzoneanalysis src/resources/point-hotzone.csv src/resources/zone-hotzone.csv hotcellanalysis src/resources/yellow_trip_sample_100000.csv
```

Note: 

1. The number/order of tasks do not matter.
2. But, the first 7 of our final test cases will be hot zone analysis, the last 8 will be hot cell analysis.


### Input data format
The main function/entrace is "cse512.Entrance" scala file.

1. Point data: the input point dataset is the pickup point of New York Taxi trip datasets. The data format of this phase is the original format of NYC taxi trip which is different from the previous phase. But the coding template already parsed it for us. Find the data from our asu google drive shared folder: [https://drive.google.com/drive/folders/1W4GLKNsGlgXp7fHtDlhHEBdLVw_IuAXh?usp=sharing](https://drive.google.com/drive/folders/1W4GLKNsGlgXp7fHtDlhHEBdLVw_IuAXh?usp=sharing).

2. Zone data (only for hot zone analysis): at "src/resources/zone-hotzone" of the template

#### Hot zone analysis
The input point data can be any small subset of NYC taxi dataset.

#### Hot cell analysis
The input point data is a monthly NYC taxi trip dataset (2009-2012) like "yellow\_tripdata\_2009-01\_point.csv"

### Output data format

#### Hot zone analysis
All zones with their count, sorted by "rectangle" string in an ascending order. 

```
"-73.795658,40.743334,-73.753772,40.779114",1
"-73.797297,40.738291,-73.775740,40.770411",1
"-73.832707,40.620010,-73.746541,40.665414",20
```

#### Hot cell analysis
The coordinates of top 50 hotest cells sorted by their G score in a descending order.

```
-7399,4075,15
-7399,4075,22
-7399,4075,14
```

## Tips (Optional)
This section is same with that in Phase 1.
### How to debug your code in IDE

If you are using the Scala template

1. Use IntelliJ Idea with Scala plug-in or any other Scala IDE.
2. Append ```.master("local[*]")``` after ```..config("spark.serializer",classOf[KryoSerializer].getName)``` to tell IDE the master IP is localhost.
3. In some cases, you may need to go to "build.sbt" file and change ```% "provided"``` to ```% "compile"``` in order to debug your code in IDE
4. Run your code in IDE
5. **You must revert Step 2 and 3 above and recompile your code before use spark-submit!!!**

### How to submit your code to Spark
If you are using the Scala template

1. Go to project root folder
2. Run ```sbt clean assembly```. You may need to install sbt in order to run this command.
3. Find the packaged jar in "./target/scala-2.11/Apache-Sedona-Hotspot-Analysis-assembly-0.1.0.jar"
4. Now, you can run the jar on Spark with spark-submit command. If you already have set up the Hadoop and Spark test environment, you should be able to run the spark-submit command from your command line. Submit the jar to Spark using Spark command "./bin/spark-submit". A pseudo code example: ```./bin/spark-submit ~/GitHub/Hotspot-Analysis-Apache-Sedona-Template/target/scala-2.11/Apache-Sedona-Hotspot-Analysis-assembly-0.1.0.jar test/output hotzoneanalysis src/resources/point-hotzone.csv src/resources/zone-hotzone.csv hotcellanalysis src/resources/yellow_tripdata_2009-01_point.csv```
