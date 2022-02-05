# _Connector App_


## Features
- [x] Spring Boot
- [x] React.js
- [x] H2 Database
- [x] Bootstrap

## How to run the Application
_Normally, no data should be added to the Application reposotory but in this case some data is available pushed in the initial commit so that the App could be tested out immediately without letting the JobTask  to run first._
1. Make sure port `8081` is free and no other application is currently using it and that you also have at least `Java 1.8` installed and that `Java` is also added to your environment variables!
2. The `jar` file is provided ti start the backend open your terminal,  navigate to the `target/` dir and start the execute with `java -jar demiconConnectorApp-0.0.1-SNAPSHOT.jar`. After a couple of seconds the App will be started on port `8081`.
3. Navigate to the `/frontend` dir and first run `npm install` to install the necessary scripts and modules.
4. Then make sure that port `3000` is free. In the same directory run `npm start` to start the frontend.
5. Finally, you can open your browser and add `http://localhost:3000` to the address bar.


## How to build the Application
Since this is a maven project make sure you have Maven installed.
1. Navigate to the project's dir open a terminal and run `mvn clean install`.
2. After successful build, make sure that port `8081` is free and navigate to the the `target/` dir and run `java -jar demiconConnectorApp-0.0.1-SNAPSHOT.jar`.
3.  Or import the project into your IDE, run maven clean install from within your IDE and then you can start the backend of the App.
4. Then follow the Steps 3., 4. and 5. from above to build and run the frontend.
