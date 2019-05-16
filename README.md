Note prepared from oriely/safary course given by ken kousen

Day1
https://github.com/kousen/java_upgrade
https://github.com/kousen/java_8_recipes

http://www.kousenit.com/java8


1.Lambda
2.Stream
3.Method Expressions

1.Functional interface -> interface with only one abstract method
as then it can be used as the assignment target for a lambda expression/method reference


Lambda has be passed/assigned ; paramters types inferred from context
for compilers Lambda generates a anonymous class around it
SAM(single abstract method) (also, methods from Object doesn't qualify)

Predicates (another type of functional interface)

2 functional interfaces with same number of arguments (would it compile?)
no, as compiler cannot decide, can assign to the specific functionalInterface and then pass


expression lambda are with single lines(doesn't need return )
expression lambda pathName -> pathName.isDirectory();
    normal lambda pathName -> {return pathName.isDirectory();}
Method Reference              FileFilter::isDirectory
1
System.out.println
System.out::println
2 X,Y triggerd on static method with parameters X and Y
Math.ax(x,y)
Math::max
3 X,Y (triggered on the X with argument Y)
"".compareToIgnooreCase
String::compaeToIgnorecase

Constructor Reference
1. ArrayList::new
2. List[]::new
3. function understands and binds based on the context
	3a.Person(string args)
	3b.Person(String ...args)
	3c.Person(Person p)
	
eg1	String.stream().map(Person::new) (as per context is binds 3a)
eg2	Strng.stream().map(str->str.split(" "))
	.map(Person::new) (as per context binds 3b)
eg3 String.stream.map(Person::new)(as per context binds 3a)
	.map(Person::new)	(as per context binds 3c)
	
collect(supplier <R>,accumulator<T,R>,combiner<R,R>)
collect(LinkedList::new,LinkedList::add,LinkedList::addAll)
Combiner is for parallerStreams only

Functiona Interfaces(https://docs.oracle.com/javase/8/docs/api/?java/util/function/package-summary.html)
Predicates<T> takes one parameter returns boolean
	many statics
	many default
	only one SAM
		test(T t)
	
	BiPredicates<T,U> takes two parameter retruns boolean
	LongPredicate
	DoublePredeicate
	Intpredicate

Function<T,R> takes a T returns an R
		R apply(T t)
	For premitaves
	Double
	Int
	Long
	toDouble
	ToLong
	ToInt
	
	there is no primative-primate (same type thus unary)
	UnaryOperater
	LongUnary
	Double
	Int
	
	BiFunction<T, U, R>
	
	BinaryOperator
	Double
	Int
	Long
	
	
Consumer<T> takes one parameters returns void
	intConsumer
	longConsumer
	doubleConsumer
	Cosumer
Supplier<T> take no arguments and return T
	int
	long
	double
	boolean
	Suppliar
	

Cosumer 1 arg return none
Predicates 1 arg return bool
Supplier
Function

all have int/long/double version for premitive overrides

Bifunction TURs




SAM(single abstract met)


Default methods
forEach in List, Array

Comparator.comparingInt(lambda).thenComparigin(lambda)

also see collect.(Collector.partionby(Predicate<T>))
	
	
terminal operation

Intermediaate operatoin eg. filter (target is stream and return stream)
	peek (takes a consumer and also still returns the ame stream)
Terminal operation eg. collect (move stream to a collection)
	forEach

Composition method
//true/false
predicate.and(another predicate "run only if the previous one is true")

consumer.andThen(have multiple method references and all)
Comparator.comparingInt(lambda).thenComparigin(lambda)


Use of supplier overloaded method reduces execution of the supplier when not needed
eg. deferred logging


collector
downstram collector


Lazy processs of the streams


How to create Streams
	COllection.stream()
	Stream.of(T...vales)
	Stream.generate(Supplier)(infifincate show example below)
	Stream.iterate(T seed, UnaryOperator<T>)
	Stream.empty()
	
Stream.generate(Math::random) //inifinote
.limit(100)  //limits the infinite loop on 100th stream


reduce check the method reduce_stream_of_ints
1.   reduce() method always creates a  new value whereas collect() method updates or mutates an existing value.
     
2.  reduce() performs reduction whereas collect() performs mutable reduction.   

3.   Suppose we are want summation then using reduce(), we use as follows
 
List<Integer> list = Arrays.asList(3,2,5,6);
int sum = list.stream().reduce(0, Integer::sum);
System.out.println(sum);
 
And using collect(),  we calculate sum as follows.
 
IntSummaryStatistics stats = list.stream().collect(Collectors.summarizingInt(i->i));
System.out.println(stats.getSum());
 



extra : 
java 9 moduless
template method design pattern ?
lombark
