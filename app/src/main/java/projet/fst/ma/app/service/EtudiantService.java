package projet.fst.ma.app.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

import projet.fst.ma.app.classes.Etudiant;
import projet.fst.ma.app.util.MySQLiteHelper;

public class EtudiantService {
    private MySQLiteHelper helper;
    private static final String TABLE_NAME = "etudiant";
    // Il est conseillé de centraliser les noms de colonnes ici
    private static final String COL_ID = "id";
    private static final String COL_NOM = "nom";
    private static final String COL_PRENOM = "prenom";

    public EtudiantService(Context context) {
        this.helper = new MySQLiteHelper(context);
    }

    // --- AJOUTER UN ETUDIANT ---
    public void create(Etudiant etudiant) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NOM, etudiant.getNom());
        values.put(COL_PRENOM, etudiant.getPrenom());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // --- MODIFIER ---
    public void update(Etudiant etudiant) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NOM, etudiant.getNom());
        values.put(COL_PRENOM, etudiant.getPrenom());

        // Utilisation de String.valueOf pour une meilleure lisibilité
        String selection = COL_ID + " = ?";
        String[] selectionArgs = { String.valueOf(etudiant.getId()) };

        db.update(TABLE_NAME, values, selection, selectionArgs);
        db.close();
    }

    // --- SUPPRIMER ---
    public void delete(Etudiant e) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        // On extrait l'ID de l'objet étudiant pour savoir quelle ligne supprimer
        db.delete(TABLE_NAME, "id = ?", new String[]{String.valueOf(e.getId())});
        db.close();
    }

    // --- RECHERCHER PAR ID ---
    public Etudiant findById(int id) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Etudiant etudiant = null;

        Cursor cursor = db.query(TABLE_NAME, null, COL_ID + " = ?",
                new String[]{String.valueOf(id)}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            etudiant = mapCursorToEtudiant(cursor);
            cursor.close();
        }
        db.close();
        return etudiant;
    }

    // --- TOUT RECUPERER ---
    public List<Etudiant> findAll() {
        List<Etudiant> liste = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                liste.add(mapCursorToEtudiant(cursor));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return liste;
    }

    // --- METHODE UTILITAIRE (Pour éviter la répétition de code) ---
    private Etudiant mapCursorToEtudiant(Cursor cursor) {
        Etudiant e = new Etudiant();
        e.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID)));
        e.setNom(cursor.getString(cursor.getColumnIndexOrThrow(COL_NOM)));
        e.setPrenom(cursor.getString(cursor.getColumnIndexOrThrow(COL_PRENOM)));
        return e;
    }
}