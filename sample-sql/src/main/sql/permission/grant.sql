Prompt 'Début Création des autorisations'

/**************************/
/*  Droits sur les tables */
/**************************/
grant select, insert, delete, update, references on PM_SEC_MODEL                    to APP_USER
/
grant select, insert, delete, update, references on AP_WORKFLOW_LOG                 to APP_USER
/
grant select, insert, delete, update, references on PM_BROADCAST_COLUMNS            to APP_USER
/
grant select, insert, delete, update, references on PM_BROADCAST_FILES              to APP_USER
/
grant select, insert, delete, update, references on PM_BROADCAST_FILE_CONTENTS      to APP_USER
/
grant select, insert, delete, update, references on PM_BROADCAST_SECTION            to APP_USER
/
grant select, insert, delete, update, references on PM_BROADCAST_SELECTOR           to APP_USER
/
grant select, insert, delete, update, references on PM_FIELD_IMPORT_SETTINGS        to APP_USER
/
grant select, insert, delete, update, references on PM_IMPORT_SETTINGS              to APP_USER
/
grant select, insert, delete, update, references on PM_SOURCE_SYSTEM                to APP_USER
/
grant select, insert, delete, update, references on AP_BOOK                         to APP_USER
/

/**************************/
/*  Droits sur les vues  */
/**************************/

/**************************/
/*  Droits sur les procs  */
/**************************/

/*****************************/
/*  Groupe Consultation (BO) */
/****************************
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

grant select, references on AP_BOOK                         to Consultation
go



*/
Prompt 'Fin Création des autorisations'
