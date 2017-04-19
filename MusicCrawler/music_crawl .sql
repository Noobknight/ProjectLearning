-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2017 at 12:27 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `music_crawl`
--

-- --------------------------------------------------------

--
-- Table structure for table `music`
--

CREATE TABLE `music` (
  `id` int(11) NOT NULL,
  `music_id` varchar(20) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `image` text,
  `url` text,
  `lyric` text,
  `description` text,
  `stream` text,
  `quality` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `music`
--

INSERT INTO `music` (`id`, `music_id`, `title`, `image`, `url`, `lyric`, `description`, `stream`, `quality`) VALUES
(1, 'tsvq065zqenkh1', 'Lặng Yên', NULL, 'http://chiasenhac.vn/nhac-hot/lang-yen~bui-anh-tuan-ai-phuong~tsvq065zqenkh1.html', 'Ở một nơi xa xôi, bao quanh là núi đồi\nChuyện tình yêu vẫn cứ cũ như thế sinh ra là có đôi \nNgười chọn sinh ra thôi, không may bị cuốn trôi\nVài mảnh đời sinh ra không cho nhau đặt cạnh nên biết đau.\n\n[ĐK:] \nVà giọt nước mắt cứ thế tự nhiên lăn trên hàng mi giống như đời\nNgày qua mới biết mơ thôi mà sao vội trôi, ngọt ngào đành chia phôi\nLồng ngực còn nhói chưa thôi, ngày đã sang vội, phải trôi tiếp với đời\nTrớ trêu như đời, hiển nhiên như đời. \n\nĐiều gì gắn kết khi những hân hoan đặt ngay cạnh bên những bẽ bàng? \n\nRàng buộc không đáng yêu thương dở dang, người trong cuộc ngày thêm hoang mang \nLàm bạn trọn quãng mênh mang ngày sang đêm cạn, mình buông nhau khẽ khàng \nĐể cuốn theo gió ngàn, lẩn giữa những đốm vàng tình khẽ bay nhẹ nhàng.', '', 'http://data.chiasenhac.com/stream/1778/5/1777754-ea4bc0e4/128/Lang%20Yen%20-%20Bui%20Anh%20Tuan_%20Ai%20Phuong.mp3.csn', 'LOSSLESS'),
(2, 'tsvq0363qenwkw', 'Cánh Đồng Yêu Thương', NULL, 'http://chiasenhac.vn/nhac-hot/canh-dong-yeu-thuong~trung-quan~tsvq0363qenwkw.html', 'Lời sắp nói chắc sẽ đau lòng phải không em\nAnh vẫn còn nhiều hoang mang\nVì chưa tin tình mình sẽ mất\nBuồn ngỡ ngàng, xa em trái thêm lạnh\nChiều nắng tàn theo hơi ấm khi giã từ.\n\nNgày chia tay thiếu vắng anh là ngàn nỗi nhớ\nThay nhau làm con tim anh nghẹn đau\nVẫn không ngừng yêu em\nTìm mãi tìm, anh không biết đã sai gì?\nChỉ biết rằng em không bên anh nữa thôi.\n\n[ĐK:] \nLệ rơi đắng môi \nLàm vỡ tan những yêu thương bỗng thành tổn thương\nLòng càng rối bời\nVì cánh đồng yêu thương sẽ không còn đôi ta\nChắc tim em bây giờ đã có bóng dáng ai\nPhai mờ tên anh\nNhặt từng nỗi nhớ em cồn cào\n\nThầm lặng nước mắt khẽ rơi một mình.\n\nĐằng sau phút giây hạnh phúc\nGiờ đây tất cả đang dần đổi thay\nVì ai, trái tim người cứ dần xa\nNên không còn cần anh nữa\nGiấc mơ trong em giờ đã khác\nSẽ miên man bên hạnh phúc mới\nTình đẹp nhất vẫn luôn dang dở\nMột mình đứng khóc chơ vơ.', '', 'http://data.chiasenhac.com/stream/1779/5/1778504-f492cc6b/128/Canh%20Dong%20Yeu%20Thuong%20-%20Trung%20Quan.mp3.csn', 'LOSSLESS'),
(3, 'tsvqvsbcqe24qv', 'Yêu 5', NULL, 'http://chiasenhac.vn/nhac-hot/yeu-5~rhymastic~tsvqvsbcqe24qv.html', 'Xin những bối rối này cứ thế lên ngôi \nXin con tim rẽ lối tìm giây phút nghẹn lời\nCho thêm chơi vơi, để những ánh mắt đôi môi\nChạm nhau mang theo gọi mời.\n\nXin cho ta tan vào những đắm đuối miên man\nKhi em ghé ngang đời chợt mang sắc hương thiên đàng \nVà cho những ấm áp lại đến lấp kín nhân gian\nNgày ta yên vui cùng nàng.\n\nNhẹ nhàng âu yếm giữa chốn mơ\nCùng tìm kiếm bao ý thơ\nĐể đắm say trong tiếng nhạc du dương\nHồn sa theo bước ta ngẩn ngơ\nDù ngàn kiếp ta vẫn chờ\nChỉ cần có phút giây này trao yêu thương.\n\n[ĐK:]\nCuz baby it''s always you\nIt''s always you\nIt''s always you\nIt''s always you... always you.\n\n[Rap:]\nTa như đi qua hết bao nhiêu mê say trên đời \nNhư yêu thêm cả nghìn kiếp khi ta một giây bên người\nVì chỉ cẩn một ánh nhìn mà em trao \nLà tuổi xuân của ta như hoá được thành chiêm bao\nVới mỗi sáng thức giấc nghe em bên ta vui cười\nCho đêm ta ngây ngất, ru tai êm qua đôi lời\nĐầy ngọt ngào và trong veo, cùng hoà làm trăng sao\nDìu dắt đôi tim bên nhau đi theo bao yêu thương dâng trào\n\nVà ta xin đánh đổi một rừng tia nắng để lấy chút hơi ấm của em\nXin đổi đi hết tiền bạc danh tiếng\nNhững thứ hàng trăm người thèm\nBởi cả ngàn điều phù phiếm đâu bằng một thoáng môi mềm\nKhi đời này sẽ mang đầy nuối tiếc nếu không có nàng ở bên\nNhìn em ta mới thêm yêu từng khoảnh khắc\nMang hết tương tư giấu vào theo từng bản nhạc\nĐể mai này tình nở như muôn hoa không tàn sắc\nLưu giữ mãi nơi này một câu chuyện ngàn năm.', '', 'http://data.chiasenhac.com/stream/1770/5/1769967-967ebd7b/128/Yeu%205%20-%20Rhymastic.mp3.csn', 'MP3'),
(4, 'tsvqzmcvqe18v2', 'Anh Đã Quen Với Cô Đơn', NULL, 'http://chiasenhac.vn/nhac-hot/anh-da-quen-voi-co-don~soobin-hoang-son~tsvqzmcvqe18v2.html', 'Anh thường hay vẫn nằm mơ về một ngôi nhà \nỞ một nơi chỉ có đôi ta \nNơi đã có anh và em xây từng câu chuyện \nCùng sẻ chia về những ước mơ. \n\nTrên trời cao muôn vì sao soi từng con đường \nHoà làn mây cùng gió đến đây \nEm đã nói sẽ ở bên anh thật lâu và \nChẳng thể quên được những vấn vương. \n\nCó thể anh mơ \nChỉ là giấc mơ về một hạnh phúc \nNắng phai trên mi ai \nGiờ em nơi đâu có biết chăng nơi này. \n\nCó lẽ em đã quên rồi \nTừng chiếc ôm trong tiết sang trời trở đông \nNhững ngón tay ta đan chặt \nNhìn nhau thật lâu và chẳng cần nói điều gì. \n\n[ĐK:] \nEverynight alone \nĐừng để giọt nước mắt vẫn rơi \nTàn hoa khắp nơi thiếu em, babe \n\nEverynight alone \nLại gọi tên những nổi nhớ đong đầy. \n\n[Rap:]\nBao đam mê cũng đã chóng phai \nYêu em không biết đúng sai \nChỉ bằng cảm xúc, bằng lý trí \nBằng tất cả những gì anh có hay em cho \nKhi hai con tim lệch nhịp \nAnh có cố gắng thế nào, em cũng không hiểu được em \nNhư là bản thân chính em.', '', 'http://data.chiasenhac.com/stream/1774/5/1773033-d6fe0a4a/128/Anh%20Da%20Quen%20Voi%20Co%20Don%20-%20Soobin%20Hoang%20So.mp3.csn', 'LOSSLESS'),
(5, 'tsvqz0c3qe1nvw', 'Yêu 5 (Rhymastic Remix)', NULL, 'http://chiasenhac.vn/nhac-hot/yeu-5-rhymastic-remix~rhymastic~tsvqz0c3qe1nvw.html', 'Xin những bối rối này cứ thế lên ngôi\nXin con tim rẽ lối tìm giây phút nghẹn lời\nCho thêm chơi vơi, để những ánh mắt đôi môi\nChạm nhau mang theo gọi mời.\n\nXin cho ta tan vào những đắm đuối miên man\nKhi em ghé ngang đời chợt mang sắc hương thiên đàng\nVà cho những ấm áp lại đến lấp kín nhân gian\nNgày ta yên vui cùng nàng.\n\nNhẹ nhàng âu yếm giữa chốn mơ\nCùng tìm kiếm bao ý thơ\nĐể đắm say trong tiếng nhạc du dương\nHồn sa theo bước ta ngẩn ngơ\nDù ngàn kiếp ta vẫn chờ\nChỉ cần có phút giây này trao yêu thương.\n\n[ĐK:] \nCuz baby it''s always you \nIt''s always you \nIt''s always you \nIt''s always you... Always you.\n\n[Rap:] \nTa như đi qua hết bao nhiêu mê say trên đời\nNhư yêu thêm cả nghìn kiếp khi ta một giây bên người\nVì chỉ cẩn một ánh nhìn mà em trao\nLà tuổi xuân của ta như hoá được thành chiêm bao\nVới mỗi sáng thức giấc nghe em bên ta vui cười\nCho đêm ta ngây ngất, ru tai êm qua đôi lời\nĐầy ngọt ngào và trong veo, cùng hoà làm trăng sao\nDìu dắt đôi tim bên nhau đi theo bao yêu thương dâng trào \n\nVà ta xin đánh đổi một rừng tia nắng\nĐể lấy chút hơi ấm của em\nXin đổi đi hết tiền bạc danh tiếng\nNhững thứ hàng trăm người thèm\nBởi cả ngàn điều phù phiếm đâu bằng một thoáng môi mềm\nKhi đời này sẽ mang đầy nuối tiếc nếu không có nàng ở bên\nNhìn em ta mới thêm yêu từng khoảnh khắc\nMang hết tương tư giấu vào theo từng bản nhạc\nĐể mai này tình nở như muôn hoa không tàn sắc\nLưu giữ mãi nơi này một câu chuyện ngàn năm.', '', 'http://data.chiasenhac.com/stream/1776/5/1775080-51f05a21/128/Yeu%205%20Rhymastic%20Remix_%20-%20Rhymastic.mp3.csn', 'MP3'),
(6, 'tsvqv0c0qe2nvn', 'Đi Để Trở Về', NULL, 'http://chiasenhac.vn/nhac-hot/di-de-tro-ve~soobin-hoang-son~tsvqv0c0qe2nvn.html', 'Tôi ₫ang ở một nơi rất xa\nNơi không có khói bụi thành phố\nỞ một nơi đẹp như mơ, trên cao êm êm mây trắng bay\nLặng nhìn biển rộng sóng vỗ\nCuộc đời tôi là những chuyến đi dài.\n\nVượt suối thác, vượt núi dốc\nDù chênh vênh có xá gì \nCó biết bao thứ tươi ̣đẹp vẫn cứ ở đó đang chờ tôi\nNgười xung quanh, ở nơi đây thật dễ mến, sống với thơ\nÁnh mắt lấp lánh hiền hoà chào tôi chào người bạn mới.\n\n[ĐK:]\nTừng chặng đường dài mà ta qua giờ ngồi một mình lại thấy nhớ\nNgày ngày mặt trời rạng ngời vươn cao lên từ trên mái nhà\nTừng chặng đường dài mà ta qua đều để lại kỉ niệm quý giá\nÐể lại một điều rằng càng đi xa ta càng thêm nhớ nhà\n\nĐi thật xa để trở về\n\nĐi thật xa để trở về\nCó một nơi để trở về\nĐi... đi để trở về.\n\n[Coda:]\nCuộc đời thật đẹp khi được đi muôn nơi xa xôi rộng lớn \nNhưng ta vẫn có nơi để trở về sau một chuyến đi\nĐiều kì diệu là con người ta đi xa hơn để trưởng thành hơn\nKhông quên mang theo bên cạnh hành trang nỗi nhớ gia đình.', '', 'http://data.chiasenhac.com/stream/1771/5/1770987-5c084f1e/128/Di%20De%20Tro%20Ve%20-%20Soobin%20Hoang%20Son.mp3.csn', 'LOSSLESS'),
(7, 'tsvq0c3cqenvwv', 'Lại Nhớ Người Yêu', NULL, 'http://chiasenhac.vn/nhac-hot/lai-nho-nguoi-yeu~dan-nguyen~tsvq0c3cqenvwv.html', 'Vì sao anh nhớ em thế này? \nThương nhớ đong đầy trong lòng mắt \nBuổi chiều còn gặp nhau đây \nMà đêm đã nhớ như vậy! \nEm hỡi em có hiểu có hay? \n\nTình anh như núi cao biển rộng\nGom bốn phương trời xây thành luỹ \nBiển trời nào mà không xanh\nThì xin em nhớ cho rằng \nEm hiển nhiên chiếm ngự hồn anh.\n\n[ĐK:] \nEm ơi! Ngồi đây thương bóng thương hình \nNgồi đây tơ tưởng riêng mình \nVới niềm mơ ước vây quanh \nEm ơi! Ước gì mình là đôi chim \n\nƯớc gì mình là sao đêm \nHay là trăng rọi sáng đường hoa. \n\nĐể anh đưa đón em sớm chiều \nTrên lối đi về không còn thiếu \nTrọn đời mình gần bên nhau\nTình yêu thêm sắc thêm màu \nKhông còn lo thương nhớ người yêu.', '', 'http://data.chiasenhac.com/stream/1777/5/1776239-53f56652/128/Lai%20Nho%20Nguoi%20Yeu%20-%20Dan%20Nguyen.mp3.csn', 'LOSSLESS'),
(8, 'tsvqvm7cqe28tv', 'Em Không Là Duy Nhất', NULL, 'http://chiasenhac.vn/nhac-hot/em-khong-la-duy-nhat~toc-tien~tsvqvm7cqe28tv.html', '1. Từ lâu em cũng đã nhận ra\nVới anh em không là duy nhất\nNếu em mãi im lặng\nKết cuộc ta sẽ ra sao?\n\n2. Thì anh vẫn sẽ là chính anh\nVẫn luôn quay về vẫn êm ấm\nMà tại sao từ trong tâm trí em\nCứ bảo em phải ra đi?\n\n[ĐK:] \nChọn con tim hay là nghe lý trí?\nChọn yêu anh hay chọn phút giây biệt ly?\nDòng lệ hoen bờ mi hoen bờ mi \nPhải chăng đã bấy lâu nhu nhược để bên anh \nĐể yêu anh phải không? \n\nChọn con tim hay là nghe lý trí?\nChọn yêu anh hay chọn phút giây biệt ly?\nThầm mong anh nhận ra, anh nhận ra \nTrước khi đã quá muộn thì những sai lầm xưa \n\nChỉ là quá khứ thôi, bỏ qua vì nhau.\n\n3. Ngày qua em biết phải sống sao?\nSống bên những sai lầm của anh\nMà tại sao từ trong tâm trí em\nCứ bảo em phải ra đi?\n\n[Coda:]\nBởi trong tim mình dường như cả hai còn yêu \nCòn cần bên nhau, còn quan tâm nhau dài lâu.', '', 'http://data.chiasenhac.com/stream/1770/5/1769007-c537e43b/128/Em%20Khong%20La%20Duy%20Nhat%20-%20Toc%20Tien.mp3.csn', 'LOSSLESS'),
(9, 'tsvq0d5dqenmhm', 'Anh Sẽ Về Sớm Thôi', NULL, 'http://chiasenhac.vn/nhac-hot/anh-se-ve-som-thoi~isaac~tsvq0d5dqenmhm.html', '1. Đôi khi anh thường muốn có niềm vui\nỗi tối rong chơi đây đó cùng bạn bè gần xa\nKhi xưa anh là thế đấy\nGiờ đây đã có ai đó trông ngông trở về nhà thật nhanh.\n\n2. Một nụ hôn ấm áp, vòng tay ôm phía sau\nSẽ là nụ cuời, niềm hạnh phúc mà ta đã mơ\nCứ trôi qua một ngày nhớ\nChỉ cần nhìn thấy em cười vui.\n\n[ĐK:]\nVà rồi anh sẽ trở về\nTrước khi nắng tắt hoàng hôn, từng chiều\nĐể em khi ấy mỉm cười đón anh\nXớt chia buồn vui, từng ngày.\n\nĐừng lo mỗi khi em chờ \nVì anh sẽ về sớm thôi.\n\n3. Đôi khi xa là nhớ lắm, buồn vui đâu biết\nChỉ có nỗi nhớ, chỉ sợ chờ thật lâu \nDẫu vài lần thôi, anh yêu em vì thế đấy\nChỉ cần bên anh dù có mưa gió chẳng sợ điều gì đâu.\n\n\n[Coda:]\nĐếm nước mắt cũng chẳng được đâu\nVì nụ cười mình được ở bên nhau \nĐể cho ai giờ, phải làm sao giờ?\nKhi thêm một dòng tin nhắn đến.\n\nKhông phải chờ lâu nữa đâu\nChỉ một thoáng phút chốc nhiệm màu \nAnh sẽ quay về đây và ôm đôi vai em\nVà luôn là như thế.', '', 'http://data.chiasenhac.com/stream/1776/5/1775950-9331b5c6/128/Anh%20Se%20Ve%20Som%20Thoi%20-%20Isaac.mp3.csn', 'LOSSLESS'),
(10, 'tsvqzr53qe1ahw', 'Có Được Không Em', NULL, 'http://chiasenhac.vn/nhac-hot/co-duoc-khong-em~chi-dan~tsvqzr53qe1ahw.html', 'Đã đến lúc anh nói ra tâm tư lòng anh \nLuôn nghĩ đến em trong những ngày qua\nBiết sao giờ? Tình yêu đến, anh đâu thể ngờ\nChẳng biết phải nói sao cho em hiểu thấu\nTình yêu của anh bắt đầu từ đâu\nChỉ biết rằng đã từ rất lâu.\n\nVì em đâu hay, em nào hay biết\nAnh vẫn luôn ở đây\nMột nửa của em (Tình yêu của em), cứ mãi tìm kiếm đến bao giờ vậy? \nTìm hoài chi em ơi nơi nào xa xôi\nHạnh phúc đã ở đây rồi\nMột lần nhìn về nơi anh xin em cho anh nói một lời\n\n[ĐK:]\nLàm người yêu anh đi nhé em ơi\nBởi vì anh lỡ yêu em mất rồi\nAnh vẫn hay tưởng tượng thức giấc, mỗi ngày thấy em\nĐược cùng em đón ban mai trong bình yên. \n\nCầm tay nhau ngao du khắp thế gian\n\nTa cùng vẽ tương lai bao phép màu\nĐi khắp địa cầu, cho dẫu ra sao chẳng xa nhau\nMỗi ngày yêu em nhiều hơn có được không em?\n\n[Coda:]\nYêu anh đi em nhé\nDẫu tháng ngày trôi qua\nMọi điều thoáng qua\nTình yêu đôi ta cũng không bao giờ lìa xa.\n\nThiên đường là đây\nGiấc mơ của đôi ta ở đây\nĐược không em ơi?\nCầm tay cho anh theo với.', '', 'http://data.chiasenhac.com/stream/1773/5/1772632-28ba731c/128/Co%20Duoc%20Khong%20Em%20-%20Chi%20Dan.mp3.csn', 'LOSSLESS'),
(11, 'tsvq0rdmqenam8', 'Vùng Lá Me Bay', NULL, 'http://chiasenhac.vn/nhac-hot/vung-la-me-bay~duong-hong-loan~tsvq0rdmqenam8.html', 'Nhìn lá me bay nhớ kỷ niệm hai chúng mình\nNgày đó quen nhau vương chút tình trên tóc mây\nĐôi mắt thơ ngây, hoa nắng ươm đầy\nĐẹp tựa như lá me bay nên tình anh trót vay.\n\nNgày đó yêu nhau chúng ta thường qua lối này\nTừng lá me bay vương gót hài hoa bướm say\nTơ nắng đơm bông, trên má em hồng\nĐẹp tựa như lá me rơi khung trời xanh ước mơ.\n\nTa xa nhau\nLúc hè về rơi xác phượng buồn\nNẻo thành đô khói ngập trời\nVùng luyến thương ơi.\n\nMùa thu dâng cao\nBiết là người yêu đang mong\n\nXin hiểu giùm\nLửa còn đốt cháy quê hương.\n\nGiờ đã xa nhau những kỷ niệm xin vẫy chào\nVùng lá me bay năm tháng dài thương nhớ ai\nEm cố quên đi, thương nhớ làm gì\nTình mình như lá me rơi trên dòng xuôi biển khơi.', '', 'http://data.chiasenhac.com/stream/1777/5/1776595-be92805f/128/Vung%20La%20Me%20Bay%20-%20Duong%20Hong%20Loan.mp3.csn', 'LOSSLESS'),
(12, 'tsvdtt7zqmfft1', 'Loving You', NULL, 'http://chiasenhac.vn/nhac-hot/loving-you~mai-tien-dung~tsvdtt7zqmfft1.html', '', '', 'http://data.chiasenhac.com/stream/1780/5/1779514-e648fc68/128/Loving%20You%20-%20Mai%20Tien%20Dung.mp3.csn', 'LOSSLESS'),
(13, 'tsvqz070qe1ntn', 'Cô Gái Ngày Hôm Qua', NULL, 'http://chiasenhac.vn/nhac-hot/co-gai-ngay-hom-qua~vu-cat-tuong~tsvqz070qe1ntn.html', '1. Lắng nghe em lúc này\nThoảng hư không về đây, tuổi thơ về đây\nThắt tim anh lúc này\nNhững thương yêu ngày đêm vẫn in sâu như thước phim.\n\nNgày thơ bé bên nhau\nAnh chẳng hay biết rằng mình yêu em\nChỉ mong ta mai sau\nPhút giây mình trở lại sẽ tìm thấy nhau.\n\n[ĐK:]\nVì chính em, cô gái ngày hôm qua\nBiến nỗi nhớ trong anh thành mong manh\nRồi kéo nỗi nhớ trong anh lại mây xanh.\n\nVì chính em, cô gái ngày hôm qua\nVẫn ánh mắt thơ ngây ngày bên anh\nVẫn tiếng nói sao thân thuộc bên anh... em.\n\n2. Đứng trước em lúc này, mình khóc hay đang cười đây? \n\nChẳng tin em là đây, tháng năm anh lớn khôn \nNhững dấu vết trên gương mặt em\nVẫn ở đó in sâu và ngủ yên.\n\nNgày thơ bé bên nhau \nAnh chẳng hay biết rằng, mình yêu em \nNhận ra em hôm nay \nAnh chờ khoảnh khắc này để muốn nói với em.', '', 'http://data.chiasenhac.com/stream/1776/5/1775163-7fecb96a/128/Co%20Gai%20Ngay%20Hom%20Qua%20-%20Vu%20Cat%20Tuong.mp3.csn', 'LOSSLESS'),
(14, 'tsvq0zb3qen1qw', 'Cuộc Đời Là Những Bước Chân', NULL, 'http://chiasenhac.vn/nhac-hot/cuoc-doi-la-nhung-buoc-chan~ha-anh-tuan-bich-phuong~tsvq0zb3qen1qw.html', '1. Nhớ xưa thật xưa\nBước chân chập chững hay khóc nhè\nChúng ta tập đi vững dần nhờ Mẹ\nEm lớn lên ngập tràn yêu thương\nĐôi bước chân cùng trường.\n\n2. Cấp Hai vội qua\nChúng ta lười lắm hay trốn học\nLấm lem chạy theo đám bạn cùng phòng\nMưa nắng ta cùng về chung đôi\nEm biết yêu thật rồi.\n\n[Chorus:]\nPhút giây này em giữ muôn đời\nMai này mang theo khắp nơi\nKhoảnh khắc ấy tuyệt vời\nNguyện giữ mãi trọn đời.\n\nDẫu xa mà ta ngỡ như gần\nTa cùng nâng niu bước chân\nAnh hứa sẽ yêu em\nNăm tháng mãi bên em.\n\n3. Cuối năm mười hai\nDáng em đẹp lắm trong áo dài\nCách xa làm anh đếm ngày từng ngày\n\nAnh khát khao tìm về muôn nơi\nEm bước theo dòng đời.\n\n[Chorus:]\nBước chân này em giữ muôn đời\nMai này mang theo khắp nơi\nKhoảnh khắc ấy tuyệt vời\nNguyện giữ mãi trọn đời.\n\nDẫu xa mà ta ngỡ như gần\nTa cùng nâng niu bước chân\nAnh hứa sẽ yêu em\nNăm tháng mãi bên em.', '', 'http://data.chiasenhac.com/stream/1779/5/1778936-96f13735/128/Cuoc%20Doi%20La%20Nhung%20Buoc%20Chan%20-%20Ha%20Anh%20Tua.mp3.csn', 'LOSSLESS'),
(15, 'tsvq067qqenkte', 'Giả Vờ Thương Anh Được Không', NULL, 'http://chiasenhac.vn/nhac-hot/gia-vo-thuong-anh-duoc-khong~chu-bin~tsvq067qqenkte.html', '1. Có bao giờ em nhớ anh không \nĐã bao giờ em thương anh dù chỉ một lần \nHay chỉ là một giấc mơ \nMà anh nghĩ chưa tồn tại bao giờ. \n\nEm đã từng khóc vì anh chưa \nChắc chưa từng vì anh là người thừa \nAnh xin dừng để gói ghém yêu thương \nCất ở nơi mà không một ai biết được. \n\n[ĐK:]\nEm ơi anh muốn đi cùng em đi hết đoạn đường đời \nỞ nơi đó chỉ có anh và em thôi \nNơi yên bình nhất nơi anh mơ tất cả là sự thật \nNhưng điều đó chắc khó lắm phải không. \n\nBên em giờ đây chắc có hơi ai tràn đầy \nAnh cứ vá nhưng em lại phá cũng bằng không \nEm ơi anh lạnh lắm anh sợ lắm khi đông lạnh về \nGiả vờ như em thương anh có được không. \n\n2. Có bao giờ em nhớ anh không \n\nĐã bao giờ em thương anh dù chỉ một lần \nHay chỉ là một giấc mơ \nMà anh nghĩ chưa tồn tại bao giờ. \n\nEm đã từng khóc vì anh chưa \nChắc chưa từng vì anh là người thừa \nAnh xin dừng để gói ghém yêu thương \nCất ở nơi mà không một ai biết được.\n\n[ĐK X2:]\n\nChỉ là anh đang mơ giấc mơ \nKhông có em trong đời.', '', 'http://data.chiasenhac.com/stream/1778/5/1777709-b299a2bf/128/Gia%20Vo%20Thuong%20Anh%20Duoc%20Khong%20-%20Chu%20Bin.mp3.csn', 'LOSSLESS'),
(16, 'tsvq0zc6qen1vk', 'Dù Anh Muốn', NULL, 'http://chiasenhac.vn/nhac-hot/du-anh-muon~yen-trang~tsvq0zc6qen1vk.html', '', '', 'http://data.chiasenhac.com/stream/1779/5/1778917-c2de6185/128/Du%20Anh%20Muon%20-%20Yen%20Trang.mp3.csn', 'LOSSLESS'),
(17, 'tsvqzvz3qe121w', 'Về Với Em Đi', NULL, 'http://chiasenhac.vn/nhac-hot/ve-voi-em-di~tien-tien~tsvqzvz3qe121w.html', 'Anh đừng mải miết bay như mây trời, về với em. \nAnh đừng tha thiết rơi rụng như lá khô kia, về với em đi. \nAnh đừng như sóng xô mải miết vỗ bờ không màng tháng năm, về lại với em đi. \n\n1-2-3-4-5 ngày rồi không ai tìm ai\nMuốn thôi nhưng sao không thể thôi\nAi cho em xin phút giây bình yên.\n\n[ĐK:]\nĐêm trắng đêm bơ vơ giữa dòng\nDòng người đông thật đông\n\nMà lòng em không thể đi tiếp cũng không thể dừng. \n\nYêu dấu kia lửng lơ giữa chừng\nĐể lạc tay nhau 1 phút để mãi một đời, một đời ta mãi mê đi tìm \nVề lại với em đi...', '', 'http://data.chiasenhac.com/stream/1775/5/1774744-3ae5dc72/128/Ve%20Voi%20Em%20Di%20-%20Tien%20Tien.mp3.csn', 'LOSSLESS'),
(18, 'tsvq0zcsqen1v4', 'Yêu Hết Lòng Có Được Chân Thành', NULL, 'http://chiasenhac.vn/nhac-hot/yeu-het-long-co-duoc-chan-thanh~thu-thuy~tsvq0zcsqen1v4.html', 'Lời xin lỗi, đến bây giờ này mới nói \nNgười có biết trai tim này đau rất nhiều \nTừ lúc anh muốn rời xa, là lúc em đây tự hiểu rằng \nNgày tháng yêu nhau,em cũng chỉ là người thay thế bên anh \nNgười có nhớ, chính nơi đây mình chia tay \nGiọt nước mắt,giữa đêm lạnh mưa ướt nhoà \nTự hỏi em có gì sai? để anh phải đành tâm bước đi \nNiềm vui anh hôm nay từ đây, sẽ là niềm đau em suốt đời.\n\n[ĐK:]\nNhói trong lòng mang bao điều nghĩ suy \nKhi lời vô tâm người nói ra \nMình kết thúc đi người ơi có ai đó yêu anh rồi \nĐâu phải yêu hết lòng sẽ đổi lại chân thành \nTháng ngày mình bên nhau xin anh đừng đem so sánh anh hiểu không? \nMất một người ta yêu từng rất thương \nMới nhận ra trân trọng quý hơn \nthì cũng đã không còn đâu,chính em cũng thêm ưu sầu \nĐâu phải quay bước rồi sẽ có thể quay lại \n\nMối tình này xem như cơn mơ đành chôn tận sâu nơi đáy tim,người ơi! \nĐâu phải quay bước rồi sẽ có thể quay lại \ndối gạt nhau thêm chi, ai sai còn đâu ý nghĩa nữa phải không? vì ai? \n\nGiờ em muốn,muốn quên anh bằng lý trí \nVì em biết,trái tim sẽ chẳng thể nào \nGạt bỏ anh trong đời em, từng tổn thương này đang cố quên \nTai sao anh hôm nay về đây,rồi tự tìm em như thế này.', '', 'http://data.chiasenhac.com/stream/1779/5/1778919-9cb82340/128/Yeu%20Het%20Long%20Co%20Duoc%20Chan%20Thanh%20-%20Thu%20Th.mp3.csn', 'LOSSLESS'),
(19, 'tsvq0cssqenv44', 'Duyên Phận', NULL, 'http://chiasenhac.vn/nhac-hot/duyen-phan~dan-nguyen-nhu-quynh~tsvq0cssqenv44.html', '1. Phận là con gái, chưa một lần yêu ai\nNhìn về tương lai mà thấy như sông rộng đường dài\nCảnh nhà neo đơn\nBầy em chưa lớn trĩu đôi vai gánh nhọc nhằn.\n\nThầy mẹ thương em nhờ tìm người se duyên\nLòng cầu mong em đậu bến cho yên một bóng thuyền\nLứa đôi tình duyên còn chưa lưu luyến\nSợ người ta đến em khóc sau bao lời khuyên.\n\n[ĐK:]\nChưa yêu lần nào biết ra làm sao\nBiết trong tình yêu như thế nào\nSông sâu là bao nào đo được đâu\nLòng người ta ai biết có dài lâu.\n\nQua bao thời gian sống trong bình an\nLỡ yêu người ta gieo trái ngang\nNông sâu tuỳ sông làm sao mà trông\nChưa đỗ bến biết nơi nào đục trong.\n\n2. Rồi người ta đến theo họ hàng đôi bên\n\nMột ngày nên duyên một bước em nên người vợ hiền\nBỏ lại sau lưng bầy em ngơ ngác đứng trông theo mắt đượm buồn.\n\nThầy mẹ vui hơn mà lệ tràn rưng rưng\nDặn dò con yêu phải sống theo gia đạo bên chồng\nBước qua dòng sông hỏi từng con sóng\nĐời người con gái không muốn yêu ai được không?', '', 'http://data.chiasenhac.com/stream/1777/5/1776231-19ea41c1/128/Duyen%20Phan%20-%20Dan%20Nguyen_%20Nhu%20Quynh.mp3.csn', 'LOSSLESS');

-- --------------------------------------------------------

--
-- Table structure for table `singer`
--

CREATE TABLE `singer` (
  `music_id` varchar(20) NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  `age` int(5) DEFAULT '0',
  `description` text,
  `avatar` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `singer`
--

INSERT INTO `singer` (`music_id`, `name`, `age`, `description`, `avatar`) VALUES
('tsvq065zqenkh1', 'Bùi Anh Tuấn ft Ái Phương', 0, '', 'http://chiasenhac.vn/data/face/1/155.jpg'),
('tsvq0363qenwkw', 'Trung Quân', 0, '', 'http://chiasenhac.vn/data/face/1/140.jpg'),
('tsvqvsbcqe24qv', 'Rhymastic', 0, '', 'http://chiasenhac.vn/data/face/1/530.jpg'),
('tsvqzmcvqe18v2', 'Soobin Hoàng Sơn', 0, '', 'http://chiasenhac.vn/data/face/1/387.jpg'),
('tsvqz0c3qe1nvw', 'Rhymastic', 0, '', 'http://chiasenhac.vn/data/face/1/530.jpg'),
('tsvqv0c0qe2nvn', 'Soobin Hoàng Sơn', 0, '', 'http://chiasenhac.vn/data/face/1/387.jpg'),
('tsvq0c3cqenvwv', 'Đan Nguyên', 0, '', 'http://chiasenhac.vn/data/face/1/9.jpg'),
('tsvqvm7cqe28tv', 'Tóc Tiên', 0, '', 'http://chiasenhac.vn/data/face/1/377.jpg'),
('tsvq0d5dqenmhm', 'Isaac', 0, '', 'http://chiasenhac.vn/data/face/1/371.jpg'),
('tsvqzr53qe1ahw', 'Chi Dân', 0, '', 'http://chiasenhac.vn/data/face/1/239.jpg'),
('tsvq0rdmqenam8', 'Dương Hồng Loan', 0, '', 'http://chiasenhac.vn/data/face/1/485.jpg'),
('tsvdtt7zqmfft1', 'Mai Tiến Dũng', 0, '', ''),
('tsvqz070qe1ntn', 'Vũ Cát Tường', 0, '', 'http://chiasenhac.vn/data/face/1/266.jpg'),
('tsvq0zb3qen1qw', 'Hà Anh Tuấn ft Bích Phương', 0, '', 'http://chiasenhac.vn/data/face/1/591.jpg'),
('tsvq067qqenkte', 'Chu Bin', 0, '', 'http://chiasenhac.vn/data/face/1/87.jpg'),
('tsvq0zc6qen1vk', 'Yến Trang', 0, '', ''),
('tsvqzvz3qe121w', 'Tiên Tiên', 0, '', 'http://chiasenhac.vn/data/face/1/382.jpg'),
('tsvq0zcsqen1v4', 'Thu Thuỷ', 0, '', 'http://chiasenhac.vn/data/face/1/701.jpg'),
('tsvq0cssqenv44', 'Đan Nguyên ft Như Quỳnh', 0, '', 'http://chiasenhac.vn/data/face/1/9.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `music`
--
ALTER TABLE `music`
  ADD PRIMARY KEY (`id`),
  ADD KEY `music_id` (`music_id`);

--
-- Indexes for table `singer`
--
ALTER TABLE `singer`
  ADD KEY `music_id` (`music_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `music`
--
ALTER TABLE `music`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
