# Project info
This is a simple window application implemented in Java with [Swing](https://en.wikipedia.org/wiki/Swing_%28Java%29), [Spring](https://spring.io/), and [Hibernate](https://hibernate.org/). Application main functionalities are:
- Sending HTTP requests to [Trello API](https://developers.trello.com/reference#introduction) with spring framework web client RestTemplate.
- Persisting data in the database with Hibernate.
- Dynamically generating Graphical User Interface dependent on amount of data which have been fetched from Trello.

In application, you can insert [Trello Key & Token](https://trello.com/app-key) in order to fetch boards, lists, and cards which are on your Trello account with button `Fetch data from Trello`. After fetching data from Trello there will be dynamically generated GUI with names and IDs of boards, lists, and cards from your Trello account. After that, you will be able to update name of every object simply by changing object name and clicking button `Push to Trello` or save it locally into the database with button `Push to database`.

# Project Objectives
- Learn basics of Swing library and how to create GUI.
- Practice association mappings between entities in Hibernate.
- Practice how to send HTTP requests in Java code.

# Project insight
![App](/misc/app-screen.png)