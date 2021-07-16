Coverage: 75.5%
# Inventory Management System - George Whyte
This project allowed for a base to implement all of the knowledge that we have learnt over the last 3 weeks on Java, especially including the OOP principles which were a main factor that has developed my understanding on Java better.

One Paragraph of project description goes here

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

The software that needed to be installed were mySQL, Java and Eclipse. These were the main softwares and applications that needed to be installed in order to complete the project. There are additional feautures that were needed when installing java, such as dependencies for the pom needed to be imported from maven in order to test and create a maven project.

### Installing

This installation requires the use of Eclipse (Java IDE) or similar.

A link of this Github repo is required in order to start

Once the link is copied, find the import option in Eclipse and select Projects with git, the one that has the smart install feature

Import the link from the Github account you have copied and it and pressed Next a few times, it shall be in your project explorer

MySQl will then need to be used to create a database. This should be done in the Schema file which is located under both main and test resources.

In order to finish, a connection needs to be established to the databased in which the same location the Schema is there is a db.properties file in which you input the link, user name, and password.

Once these steps listed above have been complete, the software should be able to be ran from the runner class.

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

There are varius groups that were involved in testing, which were DAO's, Controllers and Domain.

This test connects to the database and reads all the items that are in the items table in the SQL database, while if one item is out of position or the ID is wrong it will not gather the information. Furthermore, this test can be run through the src/test/java and run using JUnit through the implementation of dependencays to run these tests.

```
@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "Ernie ball Strings", 5.40));
		expected.add(new Item(2L, "Adapter", 3.50));
		expected.add(new Item(3L, "Sausage", 4.00));
		expected.add(new Item(4L, "EMG humbuckers", 145.23));
		assertEquals(expected, DAO.readAll());
	}

```
## Deployment


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use Github(http://github.org/) for versioning

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **George Whyte** - *Project work* 

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

I would like to give a massive shout out to Pawel and Alan for helping me with issues that I could not understand, and continually Pawel as his efforts to help are incredible.
Additionally, I would like to thank the team I was working in as we all shared help which made us all much more comfortable with the project.
Finally, I would like to thank David for being able to work through problems together and find solutions to errors.
