Promt 'Début de suppression des autorisations'

/**************************/
/*  Droits sur les tables */
/**************************/
revoke all on PM_SEC_MODEL                          from APP_USER
/
revoke all on AP_WORKFLOW_LOG                       from APP_USER
/
revoke all on PM_BROADCAST_COLUMNS                  from APP_USER
/
revoke all on PM_BROADCAST_FILE_CONTENTS            from APP_USER
/
revoke all on PM_BROADCAST_FILES                    from APP_USER
/
revoke all on PM_BROADCAST_SECTION                  from APP_USER
/
revoke all on PM_BROADCAST_SELECTOR                 from APP_USER
/
revoke all on PM_FIELD_IMPORT_SETTINGS              from APP_USER
/
revoke all on PM_IMPORT_SETTINGS                    from APP_USER
/
revoke all on PM_SOURCE_SYSTEM                      from APP_USER
/
revoke all on REF_AUTHOR                            from APP_USER
/
revoke all on AP_BOOK                               from APP_USER
/
revoke all on AP_ALBUM                              from APP_USER
/
revoke all on Q_AP_ALBUM                            from APP_USER
/
revoke all on Q_AP_USER_ALBUM                       from APP_USER
/
revoke all on CTRL_ALBUM                            from APP_USER
/
revoke all on PM_REF_FAMILY_REF_ASSO                from APP_USER
/
revoke all on PM_REFERENTIAL_FAMILY                 from APP_USER
/
revoke all on REF_WITH_IDENTITY                     from APP_USER
/
revoke all on SEQ_BROADCAST_SELECTION                     from APP_USER
/
/**************************/
/*  Droits sur les vues  */
/**************************/

/**************************/
/*  Droits sur les procs  */
/**************************/

Promt 'Fin de suppression des autorisations'
