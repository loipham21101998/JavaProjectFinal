-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 16, 2021 at 08:50 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lms`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `id_role` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `username`, `password`, `fullname`, `gender`, `address`, `phone`, `id_role`) VALUES
(1, 'loipham', '$2a$10$wPviZOdn9CWIRiWVaenuhupKKzgdP8l4y3biedA0eqfkLgRrrhJzO', 'Pham Huu Loi', 1, 'Ho Chi Minh City', '0938810240', 1),
(2, 'khanguyen', '$2a$10$uc5ys6I/AVY1w0a79ehDf.y4AAqmn4aKmyghO00.0aAv91LFov9cK', 'Nguyen Quoc Kha', 1, 'Ho Chi Minh City', '0923188087', 2),
(3, 'duynguyen', '$2a$10$uoS/4haoNAygV7FA2FJL4..m5hxn5rn1CtV0ZHLSI2PcazCdjjEOO', 'Nguyen Ngoc Duy', 1, 'Ho Chi Minh City', '0898982818', 2);

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `author_name` varchar(30) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` double NOT NULL,
  `id_category` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `name`, `title`, `author_name`, `description`, `quantity`, `price`, `id_category`) VALUES
(1, 'Stumbling on happiness', 'Mentality', 'Daniel Gilbert', 'Have you ever questioned how decision-making affects happiness? How can we predict whether any given thing will make us happy or unhappy? And really how will we feel when we go through that?', 3, 12, 1),
(2, 'Primitive culture\r\n', 'Culture and Society - History', 'Edward Bernett Tylor', 'In-depth research in the fields of ethnology, archeology, and cultural history. Thereby clearly seeing the transformation from wild to civilized state, the difference between cultural levels and related factors such as rituals, social institutions…\r\n', 5, 20, 2),
(3, 'The dark side of technology', 'Science and Technology – Economics', 'Peter Townsend', 'Engineering and technology play an important role, creating breakthroughs in the development of human society, thousands of years ago as well as in the current context of the Fourth Industrial Revolution. Human inventions from the flint to metal tools, the steam engine, electric power, the transistor to the electronic computer, the Internet, artificial intelligence, are the foundation, pillar for the development of all industries and fields. Thanks to scientific and technological advances, labor productivity has increased rapidly, people in many countries have become richer, affluent, healthy and live longer. However, inventions and inventions can have adverse effects on human life as well as on the natural ecological environment.', 8, 20, 3),
(4, 'The paradox of choice\r\n', 'Mentality', 'Barry Schwartz', 'In today\'s society we have too many choices from choosing what to eat for the evening, choosing clothes to go out or choosing a job out of the jobs we love. At first, it all makes us feel that life is full of interesting things.\r\n', 6, 30, 1),
(5, 'White Fang', 'Literature and Art', 'Jack London', 'At the end of the nineteenth century in Canada, people rushed to find gold in the cold northern regions. Inheriting all the quintessence of the One-eyed wolf father and Kiche mother, White Fang was born to become a lone wolf warrior with a strangely resilient survival instinct in that harsh environment.', 10, 25, 4),
(6, 'On Government', 'Legal politics\r\n', 'Marcus Tullius Cicero', 'The art of governing is essential to our lives, and an extremely complex art. We will realize its complexity when we consider the terrible mistakes of rulers throughout the ages, and still continue to this day. So they need to know better about the work they are trying to do, as well as about the achievements and salient flaws in the careers of other past administrations. In this respect, the ancient Roman government was perfectly suited and no one but Cicero could talk about it.', 3, 15, 5),
(7, 'Handbook of Chemical Technology\r\n\r\n', 'Science and Technology – Economics\r\n', 'Water Bierwerth', 'The learning content from basic to advanced in the field of Chemical Technology.\r\n', 11, 10, 3),
(9, 'How Psychology Works\r\n', 'Mentality\r\n', 'Jo Hemmings', 'What is phobia, is phobia really scary? What is psychological disorder, how to get out of that debilitating and disturbing situation? What is depression, why do modern people often encounter and struggle with this state of melancholy, fatigue and despair?\r\n', 8, 35, 1),
(10, 'Digitize or die\r\n', 'Science and Technology – Economics\r\n', 'Nicolas Windpassinger', 'Digital transformation is an inevitable trend in this day and age, it is an opportunity for Vietnam in general and businesses in particular to get ahead in the Industrial Revolution 4.0, but also a risk of falling behind and being left behind. further and further away if we don\'t care about it. Digital transformation is not simply the process of digitizing and upgrading the application of information and communication technology, but a turning point, creating a great breakthrough in socio-economic development.', 16, 32, 3),
(11, 'For whom the bell tolls', 'Literature and Art\r\n', 'Ernest Hemingway', 'In Whom Does the Bell Tolls, Hemingway cleverly detects the deep underground waves in the heart of every person who loves this difficult but beautiful life through the character Robert Jordan - an American soldier fighting in the Brigade. international. Hemingway once said, “The most essential talent of a good writer is a built-in, shockproof detector. This is the writer\'s radar and every great writer has it.\" After the work was released, the whole world seemed to have received an integrated, shockproof prophecy from Hemingway, who created an outstanding work beyond his era. It not only praises the courageous and faithful fight of the Spanish people for peace for freedom or clearly depicts the righteous international spirit that is pervading every corner, but also offers a solution. code about the deeply interconnected relationship between history and people, the place and responsibility of citizenship, life and death along with the danger of the great expansion of fascism.', 6, 13, 4),
(12, 'World Order\r\n', 'Culture and Society - History\r\n', 'Henry Kissinger', 'To have a the order of the international life and Firmware, Kissinger cho rằng nó phải liên quan đến “quyền lực có tính chính danh”. Tới cuối cùng, Kissinger, con người và tiếng nổi tiếng, có vẻ như duy tâm đến mức thực hiện bình thường. Ổ đĩa khi có những sự xung đột giữa các giá trị của Mỹ và các mục tiêu khác, chúng ta hãy tiếp tục đứng lên vì những giá trị đó, không tránh khỏi; đi đầu trong công việc giúp đỡ các quốc gia dân tộc, các lực lượng chính danh, chứ không chỉ các đơn vị phủ chính, nếu những người giúp đỡ nó bảo đảm cho các quyền cân bằng thì có thể chống đỡ các quốc tế thứ tự, cũng như những giá trị và nguyên tắc của chúng tôi có thể được những người khác chấp nhận và hấp dẫn họ.\r\n\r\n', 12, 27, 2),
(13, 'Machiavelli', 'Legal politics\r ', 'Quentin Skinner', 'Machiavelli has certainly contributed a great deal of discourse in Western thought – notably in the area of ​​political theory, but also history and historiography, Italian literature, principles of war war and diplomacy. But Machiavelli never claimed to be a philosopher—indeed, he often flatly rejected philosophical issues—and his writings are unlikely to place him in the ranks of the normative philosopher. His writings are often insanely unsystematic, at times inconsistent and self-contradictory. He tends to cite specific examples and personal experiences in lieu of tough logical analysis. Yet postnatal thinkers with all the criteria to rank first-rate philosophers were fascinated by his ideas, either arguing or using Machiavelli\'s knowledge as teaching material. .', 5, 22, 5),
(14, 'The tipping point', 'Mentality\r\n', 'Malcolm Gladwell', 'Why are fashion trends changing the way we dress? Why have different TV shows, movies, and books become so popular? Malcolm Gladwell provides a map of our society, along with an analysis of the strategies people use to influence and guide it. Gladwell describes personality types that create trends and those that influence others by “spreading information.”', 7, 11, 1);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Mentality'),
(2, 'Culture and Society - History'),
(3, 'Science and Technology – Economics'),
(4, 'Literature and Art'),
(5, 'Legal politics');

-- --------------------------------------------------------

--
-- Table structure for table `check_in`
--

CREATE TABLE `check_in` (
  `id` int(11) NOT NULL,
  `id_checkout` int(11) DEFAULT NULL,
  `id_account` int(11) DEFAULT NULL,
  `date_out` date DEFAULT NULL,
  `fine` double NOT NULL,
  `number_of_days_late` int(11) NOT NULL,
  `refund` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `check_in`
--

INSERT INTO `check_in` (`id`, `id_checkout`, `id_account`, `date_out`, `fine`, `number_of_days_late`, `refund`) VALUES
(8, 1, 3, '2021-08-08', 10, 1, 0),
(9, 1, 1, '2021-08-13', 1, 1, 0),
(17, 45, 1, '2021-08-15', 0, 0, 0),
(18, 46, 1, '2021-08-16', 0, 0, 0),
(19, 46, 1, '2021-08-17', 0, 0, 90);

-- --------------------------------------------------------

--
-- Table structure for table `check_in_details`
--

CREATE TABLE `check_in_details` (
  `id_checkin` int(11) DEFAULT NULL,
  `id_book` int(11) DEFAULT NULL,
  `id_checkout` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `check_in_details`
--

INSERT INTO `check_in_details` (`id_checkin`, `id_book`, `id_checkout`, `status`) VALUES
(17, 1, 45, 1),
(18, 7, 46, 1),
(18, 9, 46, 1),
(18, 10, 46, 1),
(18, 11, 46, 0),
(18, 12, 46, 0),
(19, 7, 46, 1),
(19, 9, 46, 1),
(19, 10, 46, 1),
(19, 11, 46, 1),
(19, 12, 46, 0);

-- --------------------------------------------------------

--
-- Table structure for table `check_out`
--

CREATE TABLE `check_out` (
  `id` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_account` int(11) DEFAULT NULL,
  `date_in` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `deposit` double DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `check_out`
--

INSERT INTO `check_out` (`id`, `id_user`, `id_account`, `date_in`, `return_date`, `deposit`, `status`) VALUES
(1, 1, 3, '2021-08-02', '2021-08-07', 10, 1),
(2, 3, 2, '2021-08-05', '2021-08-10', 30, 0),
(21, 1, 1, '2021-08-10', '2021-08-15', 20, 0),
(42, 1, 1, '2021-08-13', '2021-08-18', 105, 0),
(43, 2, 1, '2021-08-15', '2021-08-20', 135, 0),
(45, 1, 1, '2021-08-15', '2021-08-20', 12, 0),
(46, 1, 1, '2021-08-16', '2021-08-21', 117, 0);

-- --------------------------------------------------------

--
-- Table structure for table `check_out_details`
--

CREATE TABLE `check_out_details` (
  `id_checkout` int(11) DEFAULT NULL,
  `id_book` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `check_out_details`
--

INSERT INTO `check_out_details` (`id_checkout`, `id_book`) VALUES
(1, 5),
(2, 12),
(2, 3),
(1, 5),
(21, 9),
(21, 13),
(42, 6),
(42, 7),
(42, 9),
(42, 10),
(42, 11),
(43, 3),
(43, 4),
(43, 5),
(43, 6),
(43, 7),
(43, 9),
(45, 1),
(46, 7),
(46, 9),
(46, 10),
(46, 11),
(46, 12);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'admin'),
(2, 'management');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `fullname` varchar(20) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `fullname`, `gender`, `address`, `phone`) VALUES
(1, 'Alexander Jame', 1, 'California', '802-985-8146'),
(2, 'Barin Gabrie', 0, 'Florida', '937-719-4530'),
(3, 'Magnus Ovadia', 0, 'Arizona', '330-290-7009'),
(4, 'Sebastian Yona', 1, 'Montana', '319-645-0374'),
(5, 'Sebastian Nicholas', 1, 'Delaware', '787-524-8326'),
(6, 'nguyen a', 1, 'ădqdqwd', '87989789');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `phone` (`phone`),
  ADD KEY `id_role` (`id_role`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_category` (`id_category`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `check_in`
--
ALTER TABLE `check_in`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_checkin` (`id_checkout`),
  ADD KEY `id_user` (`id_account`);

--
-- Indexes for table `check_in_details`
--
ALTER TABLE `check_in_details`
  ADD KEY `id_checkout` (`id_checkin`),
  ADD KEY `id_book` (`id_book`),
  ADD KEY `id_checkin` (`id_checkout`);

--
-- Indexes for table `check_out`
--
ALTER TABLE `check_out`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_account` (`id_account`);

--
-- Indexes for table `check_out_details`
--
ALTER TABLE `check_out_details`
  ADD KEY `id_checkin` (`id_checkout`),
  ADD KEY `id_book` (`id_book`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `phone` (`phone`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `check_in`
--
ALTER TABLE `check_in`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `check_out`
--
ALTER TABLE `check_out`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`);

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`);

--
-- Constraints for table `check_in`
--
ALTER TABLE `check_in`
  ADD CONSTRAINT `check_in_ibfk_1` FOREIGN KEY (`id_checkout`) REFERENCES `check_out` (`id`),
  ADD CONSTRAINT `check_in_ibfk_2` FOREIGN KEY (`id_account`) REFERENCES `account` (`id`);

--
-- Constraints for table `check_in_details`
--
ALTER TABLE `check_in_details`
  ADD CONSTRAINT `check_in_details_ibfk_1` FOREIGN KEY (`id_checkout`) REFERENCES `check_out` (`id`),
  ADD CONSTRAINT `check_in_details_ibfk_2` FOREIGN KEY (`id_book`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `check_in_details_ibfk_3` FOREIGN KEY (`id_checkin`) REFERENCES `check_in` (`id`);

--
-- Constraints for table `check_out`
--
ALTER TABLE `check_out`
  ADD CONSTRAINT `check_out_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `check_out_ibfk_2` FOREIGN KEY (`id_account`) REFERENCES `account` (`id`);

--
-- Constraints for table `check_out_details`
--
ALTER TABLE `check_out_details`
  ADD CONSTRAINT `check_out_details_ibfk_1` FOREIGN KEY (`id_checkout`) REFERENCES `check_out` (`id`),
  ADD CONSTRAINT `check_out_details_ibfk_2` FOREIGN KEY (`id_book`) REFERENCES `book` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
