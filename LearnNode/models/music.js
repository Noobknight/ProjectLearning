var singer = require("./singer");

var Music = function () {
}

Music.prototype.music = {};

Music.prototype.makeSinger = function (music) {
    var data = {
        "name": music.name,
        "age": music.age,
        "description": music.description,
        "avatar": music.avatar,
    }
    return data;
}

Music.prototype.jsonMusicResponse = function (music) {
    var objSinger = this.makeSinger(music);
    var res = {
        "music_id": music.music_id,
        "title": music.title,
        "image": music.image,
        "url": music.url,
        "lyric": music.lyric,
        "description": music.description,
        "stream": music.stream,
        "quality": music.quality,
        "singer": objSinger
    }
    return res;
}

Music.prototype.makeListMusic = function (rows) {
    var listMusic = [];
    rows.forEach(row => {
        listMusic.push(this.jsonMusicResponse(row));
    });
    return listMusic;
}

module.exports = Music;

