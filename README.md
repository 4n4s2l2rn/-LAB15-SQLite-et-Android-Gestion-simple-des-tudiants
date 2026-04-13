# Lab: Gestion simple des étudiants (Android & SQLite)

![Status](https://img.shields.io/badge/Status-Completed-success)
![Platform](https://img.shields.io/badge/Platform-Android-brightgreen)
![Language](https://img.shields.io/badge/Language-Java-orange)
![DB](https://img.shields.io/badge/Database-SQLite-blue)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

## 📝 Description
Ce projet est une application Android permettant de gérer une liste d'étudiants. Il illustre l'implémentation d'une base de données locale **SQLite** en utilisant une architecture en couches (Modèle, Util, Service).

## 📽️ Démonstration Vidéo
*Voici un aperçu du fonctionnement de l'application (Ajout, Recherche, Suppression) :*
<div align="center">
  <video src="media/lab15.gif" width="300" controls>
    Votre navigateur ne supporte pas la lecture de vidéos.
  </video>
</div>

## 🚀 Fonctionnalités (CRUD)
* **Create** : Ajouter un étudiant via un formulaire.
* **Read** : Rechercher un étudiant par son ID unique.
* **Update** : Mise à jour des informations (via Service).
* **Delete** : Supprimer un étudiant par son ID.

## 🏗️ Architecture du Projet
* `classes` : Modèle métier (`Etudiant.java`).
* `util` : Gestionnaire SQLite (`MySQLiteHelper.java`).
* `service` : Logique CRUD (`EtudiantService.java`).

## 👤 Auteur
* **Anas** - Étudiant à l'ENSA Marrakech
