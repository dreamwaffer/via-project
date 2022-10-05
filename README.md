<h1 align="center" style="border-bottom: none;">JumPoint</h1>

[VIA](https://sites.google.com/a/via.felk.cvut.cz/via) Semestral Project

**Author**: Lukáš Kotrbatý, kotrblu2@fel.cvut.cz

## Description

A very simple SPA application for showing places for diving. These places are usually known just to local people, my idea is to create a collection point, where everyone can find the places near them and also add new ones.

## Used APIs

- [Weather API](https://openweathermap.org/api) to get information about weather at locations of JumPoint
- [Leaflet API](https://leafletjs.com/) to show the JumPoints on the map. I used [reactJS library](https://react-leaflet.js.org/)
- Custom API with [PostgreSQL](https://www.postgresql.org/) to add/update and delete a JumPoint

## Used Technologies

- ReactJS - frontend
- Java Spring - backend
- PostgreSQL - database

## Links

[Frontend Branch](https://github.com/dreamwaffer/via-project/tree/main)  
[Backend Branch](https://github.com/dreamwaffer/via-project/tree/backend)  
[Running App](https://dreamwaffer.github.io/via-project/)  
[Backend Documentation](https://jumpoints.herokuapp.com/swagger-ui/index.html)  

## Description

The Jumpoints app allows users to share their favorite places for diving. These places (JumPoints) are usually only known locally, and this application could make it easier to find these places. The application contains only basic CRUD operations, ie:
- add a new place
- display all places
- update place
- Delete a place

The application is represented by a map on which all added JumPoints are drawn. Forms (add, edit) are rendered using [Bootstrap](https://react-bootstrap.github.io). We can also view a list of all places, sorted by browsing history on the map. Weather at specific jumpoints is updated every 30 minutes, due to limited access to weather API.
