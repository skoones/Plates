# Plates

Application for quick and simple diet planning. Enables you to store all your meals in a database and choose which ones you want to eat in a given week via a convenient weekly view. Provides useful features like adding diet type to a meal (e.g. vegan) so that you can easily choose the meals according to your needs.

**Main technologies used:** Java + Spring Boot, Vue.js + Vuetify, PostgreSQL.  
**Other technologies used:** Hibernate, Lombok, Docker, Maven.

# Running Plates

*For running Plates locally, you will need to have `docker`and `docker-compose` installed on your machine.*

Clone this repository from Github:
```
git clone https://github.com/skoones/Plates.git      
cd Plates
  ```

Run the docker-compose:
```
sudo docker-compose up
```

This will set up the app for you and the main view will be available at `http://localhost:4050/week`.

If you want to delete the application from your machine, make sure you're in the **Plates** directory (inside the cloned repository) and type 
```
sudo docker-compose down
```   
To clean up the remaining images you can use:
```
sudo docker rmi $(docker images -q plates*)
```
