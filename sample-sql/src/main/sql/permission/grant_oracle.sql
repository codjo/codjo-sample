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
grant select, insert, delete, update, references on REF_AUTHOR                      to APP_USER
/
grant select, insert, delete, update, references on AP_BOOK                         to APP_USER
/
grant select, insert, delete, update, references on AP_ALBUM                        to APP_USER
/
grant select, insert, delete, update, references on Q_AP_ALBUM                      to APP_USER
/
grant select, insert, delete, update, references on Q_AP_USER_ALBUM                 to APP_USER
/
grant select, insert, delete, update, references on CTRL_ALBUM                      to APP_USER
/
grant select, insert, delete, update, references on PM_REF_FAMILY_REF_ASSO          to APP_USER
/
grant select, insert, delete, update, references on PM_REFERENTIAL_FAMILY           to APP_USER
/

/**************************/
/*  Droits sur les vues  */
/**************************/

/**************************/
/*  Droits sur les procs  */
/**************************/

/*****************************/
/*  Groupe Consultation (BO) */
/*****************************
go

-----------------------------------
QUERY pour connexion APP_USER
-----------------------------------
    SELECT grantor, table_name, privilege
    FROM user_tab_privs_recd;


-----------------------------------
QUERY pour connexion DEVDB6_dbo
-----------------------------------

SELECT grantee, table_name, privilege
FROM user_tab_privs_made;

select name from system_privilege_map

select
      grantee,
      privilege
    from
      dba_sys_privs

UTILISATEUR

select
      null     grantee,
      username granted_role
    from
      dba_users
    where
      username = 'SMARTUSER1'

select
      grantee,
      granted_role
    from
      dba_role_privs
    where
      grantee = 'SMARTUSER1'

select
      grantee,
      granted_role
    from
      dba_role_privs
    where
      grantee = 'ROLE_UTILISATEUR_IDW'

select
      grantee,
      privilege
    from
      dba_sys_privs
where
      grantee = 'ROLE_UTILISATEUR_IDW'





String query = "select GRANTED_ROLE from DBA_ROLE_PRIVS "
                           + "where GRANTEE ='" + userName + "' "
                           + "and GRANTED_ROLE = '" + groupName.toUpperCase() + "'";

*/
Prompt 'Fin Création des autorisations'
