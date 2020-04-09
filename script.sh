javac -cp QuestionA\;jars/junit-4.13.jar QuestionA/LineComparatorTest.java
java -cp QuestionA\;jars/* org.junit.runner.JUnitCore LineComparatorTest

javac -cp QuestionB\;jars/junit-4.13.jar QuestionB/StringVersionComparatorTest.java
java -cp QuestionB\;jars/* org.junit.runner.JUnitCore StringVersionComparatorTest

rm -rf QuestionA/*.class QuestionB/*.class