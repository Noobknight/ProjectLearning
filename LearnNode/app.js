var express = require("express");
var mysql = require("mysql");
var bodyParser = require("body-parser");
var http = require("http");
var app = express();
var server = require("./routes/route.js");

function Server() {
    var self = this;
    self.connectionMysql();
}

Server.prototype.connectionMysql = function () {
    var self = this;
    var pool = mysql.createPool({
        connectionLimit : 100,
        host: "localhost",
        user: "root",
        password: "",
        database: "music_crawl",
        debug : false
    });

    pool.getConnection(function (error, connection) {
        if (error) {
            self.stop(error);
        }else{
            self.configureExpress(connection);
        }
    });

}

Server.prototype.configureExpress = function(connection){
    var self = this;
    app.use(bodyParser.urlencoded({extended : true}));
    app.use(bodyParser.json());
    var router = express.Router();
    app.use("/api", router);
    var rest_router = new server(router, connection);
    self.startServer();
}

Server.prototype.startServer = function(){
    app.listen(8080, function(){
        console.log("All right! I am alive at port 8080");
    })
}

Server.prototype.stop = function(error){
    console.log("Issue with Mysql " + error);
    process.exit(1);
}

new Server();
module.exports = app;