-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : mer. 01 oct. 2025 à 10:04
-- Version du serveur : 11.3.2-MariaDB
-- Version de PHP : 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `equida`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorievente`
--

DROP TABLE IF EXISTS `categorievente`;
CREATE TABLE IF NOT EXISTS `categorievente` (
  `id` int(11) NOT NULL,
  `libelle` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `categorievente`
--

INSERT INTO `categorievente` (`id`, `libelle`) VALUES
(1, 'été'),
(2, 'hiver'),
(3, 'printemp'),
(4, 'automne'),
(5, 'prestige'),
(6, 'yearling'),
(7, 'entrainement'),
(8, 'course'),
(9, 'classic'),
(10, 'elite physique');

-- --------------------------------------------------------

--
-- Structure de la table `cheval`
--

DROP TABLE IF EXISTS `cheval`;
CREATE TABLE IF NOT EXISTS `cheval` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(150) NOT NULL,
  `date_naissance` date NOT NULL,
  `race_id` int(11) DEFAULT NULL,
  `pere` int(11) DEFAULT NULL,
  `mere` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_race` (`race_id`),
  KEY `fk_mere` (`mere`) USING BTREE,
  KEY `fk_pere` (`pere`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `cheval`
--

INSERT INTO `cheval` (`id`, `nom`, `date_naissance`, `race_id`, `pere`, `mere`) VALUES
(1, 'Eclipse', '2017-03-12', 4, 6, 11),
(2, 'Aztec', '2019-07-04', 4, 4, 11),
(3, 'orion', '2015-05-23', 5, 9, 11),
(4, 'Tempête de Feu', '2017-03-12', 1, NULL, NULL),
(5, 'Éclair Noir', '2019-07-04', 2, NULL, NULL),
(6, 'Vent du Nord', '2015-05-23', 3, NULL, NULL),
(7, 'Comète', '2018-01-01', 4, NULL, NULL),
(8, 'Silver Snow', '2020-11-17', 5, NULL, NULL),
(9, 'Caramel', '2016-06-30', 6, NULL, NULL),
(10, 'Storm', '2021-10-10', 1, NULL, NULL),
(11, 'Mustang', '2014-08-03', 2, 10, 25),
(12, 'Rising Sun', '2019-04-22', 3, 2, 22),
(13, 'Phantom', '2016-12-05', 4, NULL, NULL),
(14, 'Pompom', '2025-07-13', 2, NULL, NULL),
(15, 'Fleur du désert', '2023-06-30', 6, NULL, NULL),
(16, 'Special Week', '1998-05-05', 3, 2, 12),
(17, 'Silence Suzuka', '1999-07-23', 2, 7, 13),
(18, 'Tokai Teio', '1997-04-10', 1, 5, 14),
(19, 'Mejiro McQueen', '2000-03-30', 4, 9, 11),
(20, 'Gold Ship', '1995-06-17', 6, 1, 15),
(21, 'Vodka', '2004-03-01', 2, 4, 12),
(22, 'Daiwa Scarlet', '1999-04-25', 3, 6, 13),
(23, 'El Condor Pasa', '1995-06-05', 6, 8, 14),
(24, 'Taiki Shuttle', '1992-04-10', 1, 3, 11),
(25, 'Mejiro Ryan', '1990-05-20', 2, 7, 15);

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `id` int(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `lieu` varchar(100) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `course`
--

INSERT INTO `course` (`id`, `nom`, `lieu`, `date`) VALUES
(1, 'Prix de l\'Arc de Triomphe', 'ParisLongchamp', '2025-10-05'),
(2, 'Grand Prix de Paris', 'ParisLongchamp', '2025-07-14'),
(3, 'Prix du Jockey Club', 'Chantilly', '2025-06-01'),
(4, 'Grand Steeple-Chase de Paris', 'Auteuil', '2025-05-18'),
(5, 'Prix de Diane', 'Chantilly', '2025-06-15'),
(6, 'Japan Cup 1999', 'Tokyo Racecourse', '1999-11-28'),
(7, 'Derby Japonais 1998', 'Tokyo Racecourse', '1998-06-07'),
(8, 'Mainichi Okan 1998', 'Tokyo Racecourse', '1998-10-11'),
(9, 'Tenno Sho Automne 1998', 'Tokyo Racecourse', '1998-11-01'),
(10, 'Japan Cup 1992', 'Tokyo Racecourse', '1992-11-29'),
(11, 'Derby Japonais 1991', 'Tokyo Racecourse', '1991-06-02'),
(12, 'Tenno Sho Printemps 1991', 'Kyoto Racecourse', '1991-04-28'),
(13, 'Tenno Sho Printemps 1992', 'Kyoto Racecourse', '1992-04-26'),
(14, 'Arima Kinen 2012', 'Nakayama Racecourse', '2012-12-23'),
(15, 'Takarazuka Kinen 2013', 'Hanshin Racecourse', '2013-06-23'),
(16, 'Japan Cup 2009', 'Tokyo Racecourse', '2009-11-29'),
(17, 'Derby Japonais 2007', 'Tokyo Racecourse', '2007-05-27'),
(18, 'Arima Kinen 2008', 'Nakayama Racecourse', '2008-12-28'),
(19, 'Queen Elizabeth II Cup 2007', 'Kyoto Racecourse', '2007-11-11'),
(20, 'Japan Cup 1998', 'Tokyo Racecourse', '1998-11-29'),
(21, 'Prix de l\'Arc de Triomphe 1999', 'Longchamp (France)', '1999-10-03'),
(22, 'Yasuda Kinen 1998', 'Tokyo Racecourse', '1998-06-14'),
(23, 'Prix Jacques le Marois 1998', 'Deauville (France)', '1998-08-16'),
(24, 'Takarazuka Kinen 1991', 'Hanshin Racecourse', '1991-06-09'),
(25, 'Tenno Sho Printemps 1991', 'Kyoto Racecourse', '1991-04-28');

-- --------------------------------------------------------

--
-- Structure de la table `coursecheval`
--

DROP TABLE IF EXISTS `coursecheval`;
CREATE TABLE IF NOT EXISTS `coursecheval` (
  `cheval` int(100) NOT NULL,
  `course` int(100) NOT NULL,
  `position` varchar(100) NOT NULL,
  `temps` time DEFAULT NULL,
  PRIMARY KEY (`cheval`,`course`),
  KEY `fk_cheval` (`cheval`) USING BTREE,
  KEY `fk_course` (`course`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `coursecheval`
--

INSERT INTO `coursecheval` (`cheval`, `course`, `position`, `temps`) VALUES
(1, 1, '2eme', '00:02:05'),
(1, 2, '1er', '00:01:59'),
(1, 3, '3eme', '00:02:08'),
(2, 1, '1er', '00:02:01'),
(2, 3, '2eme', '00:02:04'),
(2, 5, '4eme', '00:02:11'),
(3, 2, '5eme', '00:02:15'),
(3, 4, '3eme', '00:02:07'),
(4, 1, '4eme', '00:02:09'),
(4, 2, '3eme', '00:02:07'),
(4, 5, '1er', '00:02:00'),
(5, 3, '1er', '00:02:03'),
(6, 4, '2eme', '00:02:04'),
(6, 5, '5eme', '00:02:12'),
(7, 1, '3eme', '00:02:07'),
(7, 3, '4eme', '00:02:09'),
(8, 2, '2eme', '00:02:01'),
(8, 4, '1er', '00:01:59'),
(9, 5, '3eme', '00:02:05'),
(16, 6, '1er', '00:01:58'),
(16, 7, '2eme', '00:02:01'),
(17, 8, '1er', '00:02:00'),
(17, 9, 'abandon', NULL),
(18, 10, '1er', '00:01:57'),
(18, 11, '1er', '00:01:58'),
(19, 12, '1er', '00:02:01'),
(19, 13, '2eme', '00:02:04'),
(20, 14, '1er', '00:01:59'),
(20, 15, '1er', '00:01:57'),
(21, 16, '1er', '00:01:56'),
(21, 17, '1er', '00:01:55'),
(22, 18, '1er', '00:01:58'),
(22, 19, '1er', '00:01:59'),
(23, 20, '1er', '00:01:57'),
(23, 21, '2eme', '00:02:00'),
(24, 22, '1er', '00:01:58'),
(24, 23, '1er', '00:01:59'),
(25, 24, '1er', '00:02:01'),
(25, 25, '3eme', '00:02:07');

-- --------------------------------------------------------

--
-- Structure de la table `enchere`
--

DROP TABLE IF EXISTS `enchere`;
CREATE TABLE IF NOT EXISTS `enchere` (
  `numero` int(11) NOT NULL,
  `montant` float NOT NULL,
  `num_lot` int(11) NOT NULL,
  PRIMARY KEY (`numero`),
  KEY `fk_lot` (`num_lot`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `enchere`
--

INSERT INTO `enchere` (`numero`, `montant`, `num_lot`) VALUES
(1, 45000, 1),
(2, 47000, 1),
(3, 42000, 2),
(4, 50000, 3),
(5, 38000, 4),
(6, 52000, 5),
(7, 48000, 6),
(8, 55000, 7),
(9, 35000, 8),
(10, 60000, 9);

-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

DROP TABLE IF EXISTS `lieu`;
CREATE TABLE IF NOT EXISTS `lieu` (
  `id` int(11) NOT NULL,
  `libelle` varchar(100) NOT NULL,
  `nb_boxes` int(255) NOT NULL,
  `commentaire` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `lieu`
--

INSERT INTO `lieu` (`id`, `libelle`, `nb_boxes`, `commentaire`) VALUES
(1, 'Deauville – Établissement Élie de Brignac', 380, '281 lots présentés, 225 vendus\r\nPrix moyen : 11 960 euro\r\nLa salle des ventes compte 450 places assises, avec tribune presse, restaurant panoramique'),
(2, 'Saint-Cloud – Manège Boussac (hippodrome)', 200, '281 lots présentés, 225 vendus\r\nPrix moyen : 11 960 €\r\nSalle de ventes circulaire (\"manège Boussac\")'),
(3, 'Le Lion d’Angers', 130, 'Pas de commentaire');

-- --------------------------------------------------------

--
-- Structure de la table `lot`
--

DROP TABLE IF EXISTS `lot`;
CREATE TABLE IF NOT EXISTS `lot` (
  `id` int(11) NOT NULL,
  `prixDepart` float NOT NULL,
  `numCheval` int(11) NOT NULL,
  `numVente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cheval` (`numCheval`) USING BTREE,
  KEY `fk_vente` (`numVente`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `lot`
--

INSERT INTO `lot` (`id`, `prixDepart`, `numCheval`, `numVente`) VALUES
(1, 20000, 3, 1),
(2, 15000, 7, 1),
(3, 35000, 1, 2),
(4, 8000, 12, 3),
(5, 22000, 5, 4),
(6, 12000, 10, 5),
(7, 45000, 2, 2),
(8, 17000, 9, 3),
(9, 26000, 6, 1),
(10, 9500, 14, 5),
(11, 50000, 11, 1),
(12, 60000, 12, 2),
(13, 45000, 13, NULL),
(14, 70000, 14, 3),
(15, 35000, 15, 4),
(16, 55000, 16, 5),
(17, 75000, 17, NULL),
(18, 67000, 18, 1),
(19, 36000, 19, 2),
(20, 80000, 20, NULL),
(21, 58000, 21, 3),
(22, 61000, 22, 4),
(23, 49000, 23, 5),
(24, 39000, 24, NULL),
(25, 68000, 25, 1);

-- --------------------------------------------------------

--
-- Structure de la table `race`
--

DROP TABLE IF EXISTS `race`;
CREATE TABLE IF NOT EXISTS `race` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `race`
--

INSERT INTO `race` (`id`, `nom`) VALUES
(1, 'Pur-sang anglais'),
(2, 'Quarter Horse'),
(3, 'Frison'),
(4, 'Andalou'),
(5, 'Lipizzan'),
(6, 'Mustang');

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

DROP TABLE IF EXISTS `vente`;
CREATE TABLE IF NOT EXISTS `vente` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `objectifMessage` varchar(50) NOT NULL,
  `corpsMessage` varchar(150) NOT NULL,
  `lieu` int(11) NOT NULL,
  `categorie` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lieu` (`lieu`) USING BTREE,
  KEY `fk_categorie` (`categorie`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `vente`
--

INSERT INTO `vente` (`id`, `nom`, `dateDebut`, `dateFin`, `objectifMessage`, `corpsMessage`, `lieu`, `categorie`) VALUES
(1, 'Vente Élite Yearlings', '2025-08-15', '2025-08-17', 'Sélection des meilleurs yearlings', 'Vente prestigieuse à Deauville avec les meilleurs pedigrees.', 1, 6),
(2, 'Vente de Foals d’Automne', '2025-11-10', '2025-11-12', 'Découverte des futurs champions', 'Foals issus des plus grands étalons européens.', 2, 4),
(3, 'Vente Mixte d’Hiver', '2025-12-05', '2025-12-07', 'Diversité de profils', 'Juments pleines, foals, chevaux à l’entraînement et étalons.', 3, 2),
(4, 'Vente Sélective de 2 ans montés', '2025-05-20', '2025-05-20', 'Prêts à courir', 'Chevaux de 2 ans déjà débourrés et présentés en piste.', 1, 8),
(5, 'Vente Online Flash', '2025-09-25', '2025-09-25', 'Vente express en ligne', 'Plateforme digitale pour enchères rapides sur sélection limitée.', 2, 9);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cheval`
--
ALTER TABLE `cheval`
  ADD CONSTRAINT `cheval_ibfk_1` FOREIGN KEY (`pere`) REFERENCES `cheval` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `cheval_ibfk_2` FOREIGN KEY (`mere`) REFERENCES `cheval` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `fk_race` FOREIGN KEY (`race_id`) REFERENCES `race` (`id`);

--
-- Contraintes pour la table `coursecheval`
--
ALTER TABLE `coursecheval`
  ADD CONSTRAINT `coursecheval_ibfk_1` FOREIGN KEY (`cheval`) REFERENCES `cheval` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `coursecheval_ibfk_2` FOREIGN KEY (`course`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `enchere`
--
ALTER TABLE `enchere`
  ADD CONSTRAINT `enchere_ibfk_1` FOREIGN KEY (`num_lot`) REFERENCES `lot` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `lot`
--
ALTER TABLE `lot`
  ADD CONSTRAINT `lot_ibfk_1` FOREIGN KEY (`numVente`) REFERENCES `vente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `lot_ibfk_2` FOREIGN KEY (`numCheval`) REFERENCES `cheval` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `vente`
--
ALTER TABLE `vente`
  ADD CONSTRAINT `vente_ibfk_1` FOREIGN KEY (`lieu`) REFERENCES `lieu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `vente_ibfk_2` FOREIGN KEY (`categorie`) REFERENCES `categorievente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
