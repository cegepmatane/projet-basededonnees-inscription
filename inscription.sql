-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 23 Octobre 2017 à 18:21
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `inscription`
--

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE `inscription` (
  `numeroInscription` bigint(20) UNSIGNED NOT NULL,
  `nom` varchar(255) NOT NULL,
  `type` enum('Simple','Retour') NOT NULL,
  `dateAller` date NOT NULL,
  `heureAller` time NOT NULL,
  `dateRetour` date DEFAULT NULL,
  `heureRetour` time DEFAULT NULL,
  `depart` enum('Matane','Godbout','Baie-Comeau') NOT NULL,
  `destination` enum('Matane','Godbout','Baie-Comeau') NOT NULL,
  `prix` double NOT NULL,
  `tempsDebutInscription` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `idPersonne` bigint(20) UNSIGNED NOT NULL,
  `age` int(11) NOT NULL,
  `accompagnateur` tinyint(1) NOT NULL,
  `numeroInscription` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `idVehicule` bigint(20) UNSIGNED NOT NULL,
  `type` enum('Vehicule','Vehicule_qui_tire_un_autre_element','Camion','Motocyclette','Velo','Vehicule_electrique') NOT NULL,
  `largeur` double NOT NULL,
  `longeur` double NOT NULL,
  `numeroInscription` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`numeroInscription`),
  ADD UNIQUE KEY `numeroInscription` (`numeroInscription`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`idPersonne`),
  ADD UNIQUE KEY `idPersonne` (`idPersonne`),
  ADD KEY `numeroInscription` (`numeroInscription`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`idVehicule`),
  ADD UNIQUE KEY `idVehicule` (`idVehicule`),
  ADD KEY `numeroInscription` (`numeroInscription`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `numeroInscription` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `idPersonne` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `vehicule`
--
ALTER TABLE `vehicule`
  MODIFY `idVehicule` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
  ADD CONSTRAINT `fk_idPersonne_numeroInscription` FOREIGN KEY (`numeroInscription`) REFERENCES `inscription` (`numeroInscription`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `fk_idVehicule_numeroInscription` FOREIGN KEY (`numeroInscription`) REFERENCES `inscription` (`numeroInscription`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
