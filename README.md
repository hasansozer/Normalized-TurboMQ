# Normalized-TurboMQ
Implementation of the *Normalized TurboMQ* metric as explained in the following publication (Section 5.5):

[T. Lutellier, D. Chollak, J. Garcia, L. Tan, D. Rayside, N. Medvidovic, R. Kroeger, "Measuring the Impact of Code Dependencies on Software Architecture Recovery Techniques", IEEE Transactions on Software Engineering 44(2), 159-181 (2018)](https://ece.uwaterloo.ca/~lintan/publications/archrec-tse17.pdf)

## Usage
A runnable jar file is available together with the source files. It should be executed as follows:

`java -jar nturbomq.jar <dependency file> <clustering file>`

* The names of the input files are provided as command line arguments.
* The first file must enlist dependencies among the items being clustered and the second one must contain the resulting clustering.
* The input files must conform to the [RSF](http://www.rigi.cs.uvic.ca/downloads/rigi/doc/node52.html) format.
* Full path of the files must be provided.
* The set of items included in the clustering file must be consistent with those taking place in the dependency file.
