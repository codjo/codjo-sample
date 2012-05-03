Print "Début de suppression des autorisations"

/**************************/
/*  Droits sur les tables */
/**************************/
revoke all on PM_SEC_MODEL                          to Utilisateur, Maintenance, Consultation
revoke all on AP_WORKFLOW_LOG                       to Utilisateur, Maintenance, Consultation
revoke all on PM_BROADCAST_COLUMNS                  to Utilisateur, Maintenance, Consultation
revoke all on PM_BROADCAST_FILE_CONTENTS            to Utilisateur, Maintenance, Consultation
revoke all on PM_BROADCAST_FILES                    to Utilisateur, Maintenance, Consultation
revoke all on PM_BROADCAST_SECTION                  to Utilisateur, Maintenance, Consultation
revoke all on PM_BROADCAST_SELECTOR                 to Utilisateur, Maintenance, Consultation
revoke all on PM_FIELD_IMPORT_SETTINGS              to Utilisateur, Maintenance, Consultation
revoke all on PM_IMPORT_SETTINGS                    to Utilisateur, Maintenance, Consultation
revoke all on PM_SOURCE_SYSTEM                      to Utilisateur, Maintenance, Consultation
revoke all on REF_AUTHOR                            to Utilisateur, Maintenance, Consultation
revoke all on AP_BOOK                               to Utilisateur, Maintenance, Consultation
revoke all on AP_ALBUM                              to Utilisateur, Maintenance, Consultation
revoke all on Q_AP_ALBUM                            to Utilisateur, Maintenance, Consultation
revoke all on Q_AP_USER_ALBUM                       to Utilisateur, Maintenance, Consultation
revoke all on CTRL_ALBUM                            to Utilisateur, Maintenance, Consultation
revoke all on PM_REFERENTIAL_FAMILY                 to Utilisateur, Maintenance, Consultation
revoke all on PM_REF_FAMILY_REF_ASSO                to Utilisateur, Maintenance, Consultation
revoke all on REF_WITH_IDENTITY                     to Utilisateur, Maintenance, Consultation
go
/**************************/
/*  Droits sur les vues  */
/**************************/
go

/**************************/
/*  Droits sur les procs  */
/**************************/
go
Print "Fin de suppression des autorisations"
