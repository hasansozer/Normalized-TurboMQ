# Normalized-TurboMQ
Implementation of the *Normalized TurboMQ* metric as explained in the following publication (Section 5.5):

[T. Lutellier, D. Chollak, J. Garcia, L. Tan, D. Rayside, N. Medvidovic, R. Kroeger, "Measuring the Impact of Code Dependencies on Software Architecture Recovery Techniques", IEEE Transactions on Software Engineering 44(2), 159-181 (2018)](https://ece.uwaterloo.ca/~lintan/publications/archrec-tse17.pdf)

## Usage
`java -jar nturbomq.jar <dependency file> <clustering file>`

* The input files must conform to the [RSF](http://www.rigi.cs.uvic.ca/downloads/rigi/doc/node52.html) format.
* Full path of the files should be provided.
* The set of items included in the clustering file must be consistent with those taking place in the dependency file.
