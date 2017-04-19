var mysql = require("mysql");
var regex = new RegExp("^\"|\"$");

function RestRouter(router, connection) {
  var self = this;
  self.handleRouter(router, connection);
}

RestRouter.prototype.handleRouter = function (router, connection) {
  var self = this;
  router.get("/", function (req, res) {
    res.json({ "Message": "Hello World" });
  });

  router.get("/getAllMusic", function (req, res) {
    var query = "SELECT M.music_id, M.title, M.image, M.url, M.lyric, M.description, M.stream, M.quality, S.name, S.age, S.description, S.avatar FROM ?? M INNER JOIN ?? S ON S.music_id = M.music_id";
    var table = ["music", "singer"];
    query = mysql.format(query, table);
    connection.query(query, function (err, rows) {
      if (err) {
        res.json({ "Error": true, "Message": "Error executing MySQL query" });
      } else {
        res.json({ "Error": false, "Message": "Success", "Musics": rows, "count": rows.length});
      }
    });
  });

  router.get("/getMusicById", function (req, res) {
    var query = "SELECT M.music_id, M.title, M.image, M.url, M.lyric, M.description, M.stream, M.quality, S.name, S.age, S.description, S.avatar FROM music M INNER JOIN singer S ON S.music_id = M.music_id WHERE M.music_id = ?";
    var params = [req.query.id];
    query = mysql.format(query, params);
    connection.query(query, function (err, rows) {
      if (err) {
        res.json({ "Error": true, "Message": "Error executing MySQL query" });
      }
      var rowCount = rows.length;
      if (rowCount > 0) {
        res.json({ "Error": false, "Message": "Success", "Music": rows, "count": rowCount });
      } else {
        res.json({ "Error": false, "Message": "Data not found" });
      }
    });
  });

  router.get("/getMusicByTitle", function (req, res) {
    var query = "SELECT M.music_id, M.title, M.image, M.url, M.lyric, M.description, M.stream, M.quality, S.name, S.age, S.description, S.avatar FROM music M INNER JOIN singer S ON S.music_id = M.music_id WHERE M.title LIKE ?";
    var queryReq = req.query.title;
    var hasQuotes = regex.test(queryReq);
    var validParam = hasQuotes ? queryReq.replace(new RegExp("^\"|\"$", "g"), "") : queryReq;
    var params = ["%" + validParam + "%"];
    query = mysql.format(query, params);
    connection.query(query, function (err, rows) {
      if (err) {
        res.json({ "Error": true, "Message": "Error executing MySQL query" });
      }
      var rowCount = rows.length;
      if (rowCount > 0) {
        res.json({ "Error": false, "Message": "Success", "Music": rows, "count": rowCount});
      } else {
        res.json({ "Error": false, "Message": "Data not found" });
      }
    })
  });

  router.get("/getMusicByArtist", function (req, res) {
    var query = "SELECT M.music_id, M.title, M.image, M.url, M.lyric, M.description, M.stream, M.quality, S.name, S.age, S.description, S.avatar FROM music M INNER JOIN singer S ON S.music_id = M.music_id WHERE S.name LIKE ?";
    var queryReq = req.query.artist;
    var hasQuotes = regex.test(queryReq);
    var validParam = hasQuotes ? queryReq.replace(new RegExp("^\"|\"$", "g"), "") : queryReq;
    var params = ["%" + validParam + "%"];
    query = mysql.format(query, params);
    connection.query(query, function (err, rows) {
      if (err) {
        res.json({ "Error": true, "Message": "Error executing MySQL query" });
      }
      var rowCount = rows.length;
      if (rowCount > 0) {
        res.json({ "Error": false, "Message": "Success", "Music": rows, "count": rowCount});
      } else {
        res.json({ "Error": false, "Message": "Data not found" });
      }
    });
  });


}

module.exports = RestRouter;