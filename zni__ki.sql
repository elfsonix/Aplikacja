-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 18 Maj 2018, 22:38
-- Wersja serwera: 10.1.32-MariaDB
-- Wersja PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `zniżki`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `miejsca`
--

CREATE TABLE `miejsca` (
  `idmiejsca` int(11) NOT NULL,
  `nazwa` text COLLATE utf8_polish_ci NOT NULL,
  `szerokosc` float NOT NULL,
  `dlugosc` float NOT NULL,
  `kategoria` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `miejsca`
--

INSERT INTO `miejsca` (`idmiejsca`, `nazwa`, `szerokosc`, `dlugosc`, `kategoria`) VALUES
(1, 'Badura', 50.0532, 19.9559, 'obuwie'),
(2, 'Clarks', 50.0668, 19.9456, 'akcesoria'),
(3, 'Adidas', 50.0639, 19.9999, 'odzież, obuwie'),
(4, 'Martes Sport', 50.0279, 19.9506, 'obuwie'),
(5, 'Empik', 50.0631, 19.9399, 'papiernicze');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `promocje`
--

CREATE TABLE `promocje` (
  `idpromocji` int(11) NOT NULL,
  `idmiejsca` int(11) NOT NULL,
  `obnizka` text COLLATE utf8_polish_ci NOT NULL,
  `uwagi` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `promocje`
--

INSERT INTO `promocje` (`idpromocji`, `idmiejsca`, `obnizka`, `uwagi`) VALUES
(1, 1, '-30%', 'Na obuwie i torebki'),
(2, 2, '-20%', 'na kolekcję wiosna-lato 2018'),
(3, 3, '-50%', 'Na kolekcję damską'),
(4, 4, '-50zł', 'na obuwie marki Salomon'),
(5, 5, '-70%', 'na wybrane produkty');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `miejsca`
--
ALTER TABLE `miejsca`
  ADD PRIMARY KEY (`idmiejsca`);

--
-- Indeksy dla tabeli `promocje`
--
ALTER TABLE `promocje`
  ADD PRIMARY KEY (`idpromocji`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `miejsca`
--
ALTER TABLE `miejsca`
  MODIFY `idmiejsca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `promocje`
--
ALTER TABLE `promocje`
  MODIFY `idpromocji` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
