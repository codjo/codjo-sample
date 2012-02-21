Print "Début Création des autorisations"

/**************************/
/*  Droits sur les tables */
/**************************/
grant select, insert, delete, update, references on PM_SEC_MODEL                    to Utilisateur, Maintenance
grant select, insert, delete, update, references on AP_WORKFLOW_LOG                 to Utilisateur, Maintenance
grant select, insert, delete, update, references on PM_BROADCAST_COLUMNS            to Utilisateur, Maintenance
grant select, insert, delete, update, references on PM_BROADCAST_FILES              to Utilisateur, Maintenance
grant select, insert, delete, update, references on PM_BROADCAST_FILE_CONTENTS      to Utilisateur, Maintenance
grant select, insert, delete, update, references on PM_BROADCAST_SECTION            to Utilisateur, Maintenance
grant select, insert, delete, update, references on PM_BROADCAST_SELECTOR           to Utilisateur, Maintenance
grant select, insert, delete, update, references on PM_FIELD_IMPORT_SETTINGS        to Utilisateur, Maintenance
grant select, insert, delete, update, references on PM_IMPORT_SETTINGS              to Utilisateur, Maintenance
grant select, insert, delete, update, references on PM_SOURCE_SYSTEM                to Utilisateur, Maintenance
go

/**************************/
/*  Droits sur les vues  */
/**************************/
go

/**************************/
/*  Droits sur les procs  */
/**************************/
go

/*****************************/
/*  Groupe Consultation (BO) */
/*****************************/
grant select, references on PM_SEC_MODEL                    to Consultation
grant select, references on AP_WORKFLOW_LOG                 to Consultation
grant select, references on PM_BROADCAST_COLUMNS            to Consultation
grant select, references on PM_BROADCAST_FILES              to Consultation
grant select, references on PM_BROADCAST_FILE_CONTENTS      to Consultation
grant select, references on PM_BROADCAST_SECTION            to Consultation
grant select, references on PM_BROADCAST_SELECTOR           to Consultation
grant select, references on PM_FIELD_IMPORT_SETTINGS        to Consultation
grant select, references on PM_IMPORT_SETTINGS              to Consultation
grant select, references on PM_SOURCE_SYSTEM                to Consultation
go

Print "Fin Création des autorisations"