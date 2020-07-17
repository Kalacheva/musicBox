-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Июл 17 2020 г., 19:33
-- Версия сервера: 10.3.13-MariaDB-log
-- Версия PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `musicbox`
--

-- --------------------------------------------------------

--
-- Структура таблицы `album`
--

CREATE TABLE `album` (
  `id_album` bigint(20) NOT NULL,
  `id_artist` bigint(20) NOT NULL,
  `name_album` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `album`
--

INSERT INTO `album` (`id_album`, `id_artist`, `name_album`) VALUES
(1, 1, 'First album'),
(2, 1, 'Second album'),
(3, 1, 'Third album'),
(4, 1, 'Fourth album'),
(5, 1, 'Fifth album'),
(6, 1, 'Sixth album'),
(7, 1, 'Seventh album'),
(11, 1, '8th album'),
(24, 22, 'Real Rock');

-- --------------------------------------------------------

--
-- Структура таблицы `artist`
--

CREATE TABLE `artist` (
  `id_artist` bigint(20) NOT NULL,
  `id_genre` bigint(20) NOT NULL,
  `name_artist` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `artist`
--

INSERT INTO `artist` (`id_artist`, `id_genre`, `name_artist`) VALUES
(1, 1, 'Adele'),
(2, 1, 'Taylor Swift'),
(3, 1, 'Twenty One Pilots'),
(4, 1, 'Selena Gomez'),
(5, 1, 'One Direction'),
(6, 1, 'Shawn Mendes'),
(7, 1, 'Megan Taylor'),
(8, 1, 'Demi Lovato'),
(9, 1, 'Ariana Grande'),
(10, 1, 'Ed Sheeran'),
(11, 1, 'Maroon 5'),
(12, 1, 'Katy Perry'),
(15, 9, 'Baker phonk'),
(16, 9, 'Sista Mas'),
(22, 2, 'AC/DC'),
(23, 2, 'Ramstein'),
(26, 1, 'Olga Buzova');

-- --------------------------------------------------------

--
-- Структура таблицы `genre`
--

CREATE TABLE `genre` (
  `id_genre` bigint(20) NOT NULL,
  `name_genre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `genre`
--

INSERT INTO `genre` (`id_genre`, `name_genre`) VALUES
(1, 'Pop'),
(2, 'Rock'),
(3, 'Rap'),
(4, 'Hip-Hop'),
(5, 'Jazz'),
(6, 'Electronic'),
(7, 'Disco'),
(8, 'Blues'),
(9, 'Phonk');

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(27);

-- --------------------------------------------------------

--
-- Структура таблицы `song`
--

CREATE TABLE `song` (
  `id_song` bigint(20) NOT NULL,
  `file` tinyblob DEFAULT NULL,
  `id_album` bigint(20) NOT NULL,
  `name_song` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `song`
--

INSERT INTO `song` (`id_song`, `file`, `id_album`, `name_song`) VALUES
(1, NULL, 1, 'Song Name 1'),
(2, NULL, 1, 'Song Name 2'),
(3, NULL, 1, 'Song Name 3'),
(4, NULL, 1, 'Song Name 4'),
(5, NULL, 1, 'Song Name 5'),
(6, NULL, 1, 'Song Name 6'),
(7, NULL, 1, 'Song Name 7'),
(8, NULL, 1, 'Song Name 8'),
(9, NULL, 1, 'song9'),
(10, NULL, 1, 'song10');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`id_album`),
  ADD KEY `id_artist` (`id_artist`);

--
-- Индексы таблицы `artist`
--
ALTER TABLE `artist`
  ADD PRIMARY KEY (`id_artist`),
  ADD KEY `id_genre` (`id_genre`);

--
-- Индексы таблицы `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id_genre`);

--
-- Индексы таблицы `song`
--
ALTER TABLE `song`
  ADD PRIMARY KEY (`id_song`),
  ADD KEY `id_album` (`id_album`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `album`
--
ALTER TABLE `album`
  MODIFY `id_album` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT для таблицы `artist`
--
ALTER TABLE `artist`
  MODIFY `id_artist` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT для таблицы `genre`
--
ALTER TABLE `genre`
  MODIFY `id_genre` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT для таблицы `song`
--
ALTER TABLE `song`
  MODIFY `id_song` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
