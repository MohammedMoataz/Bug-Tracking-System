-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 18, 2021 at 08:33 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bug_tracking_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `bugs`
--

CREATE TABLE `bugs` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `level` int(11) NOT NULL,
  `priority` int(11) NOT NULL,
  `project` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `screenshot` varchar(300) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bugs`
--

INSERT INTO `bugs` (`id`, `name`, `type`, `level`, `priority`, `project`, `date`, `screenshot`, `status`) VALUES
(1, 'bug_1', 'type_1', 1, 1, 'project_1', '2021-01-01', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'closed'),
(2, 'bug_2', 'type_2', 1, 1, 'project_2', '2021-01-01', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'closed'),
(3, 'bug_3', 'type_3', 1, 1, 'project_3', '2021-01-01', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'closed'),
(4, 'bug_4', 'type_4', 1, 1, 'project_4', '2021-01-01', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'closed'),
(5, 'bug_5', 'type_5', 1, 1, 'project_5', '2021-01-01', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'closed'),
(6, 'bug_6', 'type_6', 1, 1, 'project_6', '2021-01-01', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'closed'),
(7, 'bug_7', 'type_7', 1, 1, 'project_7', '2021-01-01', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'closed'),
(8, 'bug_8', 'type_8', 1, 1, 'project_8', '2021-01-01', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'closed'),
(9, 'bug_9', 'type_9', 1, 1, 'project_9', '2021-01-01', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'closed'),
(10, 'bug_10', 'type_10', 1, 1, 'project_10', '2021-01-01', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'closed'),
(11, 'bug_11', 'type_11', 2, 2, 'project_11', '2021-02-02', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'opened'),
(12, 'bug_12', 'type_12', 2, 2, 'project_12', '2021-02-02', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'opened'),
(13, 'bug_13', 'type_13', 2, 2, 'project_13', '2021-02-02', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'opened'),
(14, 'bug_14', 'type_14', 2, 2, 'project_14', '2021-02-02', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'opened'),
(15, 'bug_15', 'type_15', 2, 2, 'project_15', '2021-02-02', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'opened'),
(16, 'bug_16', 'type_16', 2, 2, 'project_16', '2021-02-02', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'opened'),
(17, 'bug_17', 'type_17', 2, 2, 'project_17', '2021-02-02', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'opened'),
(18, 'bug_18', 'type_18', 2, 2, 'project_18', '2021-02-02', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'opened'),
(19, 'bug_19', 'type_19', 2, 2, 'project_19', '2021-02-02', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'opened'),
(20, 'bug_20', 'type_20', 3, 3, 'project_20', '2020-03-03', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'complete'),
(21, 'bug_21', 'type_21', 3, 3, 'project_21', '2020-03-03', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'complete'),
(22, 'bug_22', 'type_22', 3, 3, 'project_22', '2020-03-03', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'complete'),
(23, 'bug_23', 'type_23', 3, 3, 'project_23', '2020-03-03', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'complete'),
(24, 'bug_24', 'type_24', 3, 3, 'project_24', '2020-03-03', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'comlpete'),
(25, 'bug_25', 'type_25', 3, 3, 'project_25', '2020-03-03', 'D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png', 'complete');

-- --------------------------------------------------------

--
-- Table structure for table `performance`
--

CREATE TABLE `performance` (
  `bug_id` int(11) NOT NULL,
  `test_id` int(11) NOT NULL,
  `test_perf` double NOT NULL,
  `dev_id` int(11) NOT NULL,
  `dev_perf` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `performance`
--

INSERT INTO `performance` (`bug_id`, `test_id`, `test_perf`, `dev_id`, `dev_perf`) VALUES
(1, 201900085, 5, 201900737, 2),
(2, 201900085, 3, 201900737, 5),
(3, 201900085, 3, 201900737, 2),
(4, 201900085, 4, 201900737, 2),
(5, 201900085, 1, 201900737, 6),
(6, 201900085, 6, 201900992, 6),
(7, 201900085, 5, 201900992, 4),
(8, 201900085, 7, 201900992, 4),
(9, 201900085, 1, 201900992, 5),
(10, 201900085, 1, 201900992, 7),
(11, 201901003, 7, 201900737, 5),
(12, 201901003, 2, 201900737, 2),
(13, 201901003, 4, 201900737, 6),
(14, 201901003, 4, 201900737, 7),
(15, 201901003, 4, 201900737, 3),
(16, 201901003, 3, 201900992, 6),
(17, 201901003, 5, 201900992, 2),
(18, 201901003, 2, 201900992, 2),
(19, 201901003, 1, 201900992, 6),
(20, 201900746, 5, 201900737, 6),
(21, 201900746, 1, 201900737, 4),
(22, 201900746, 4, 201900737, 6),
(23, 201900746, 4, 201900737, 6),
(24, 201900746, 3, 201900992, 7),
(25, 201900746, 2, 201900992, 7);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `role`) VALUES
(201900085, 'Ahmed Osman', '333333', 'Tester'),
(201900091, 'Ahmed Mohammed', '444444', 'Project manager'),
(201900518, 'Omar Abd_Rabo', '111111', 'Admin'),
(201900737, 'Mohammed Moataz', '222222', 'Developer'),
(201900746, 'Mohamed Hesham', '333333', 'Tester'),
(201900762, 'Mahmoud Gamal', '444444', 'Project manager'),
(201900992, 'Youssef Mohamed', '222222', 'Developer'),
(201901003, 'Mohammed Bahy', '333333', 'Tester');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bugs`
--
ALTER TABLE `bugs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `performance`
--
ALTER TABLE `performance`
  ADD UNIQUE KEY `bi_fk` (`bug_id`) USING BTREE,
  ADD KEY `de_fk` (`dev_id`),
  ADD KEY `te_fk` (`test_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2019010000;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `performance`
--
ALTER TABLE `performance`
  ADD CONSTRAINT `de_fk` FOREIGN KEY (`dev_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `te_fk` FOREIGN KEY (`test_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
