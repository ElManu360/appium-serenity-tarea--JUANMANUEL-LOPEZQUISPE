# language: es

Característica: Navegacion en ApiDemos
  Como usuario de la aplicacion ApiDemos
  Quiero navegar por los menus
  Para verificar que las secciones se muestran correctamente


  @navegacion
  Esquema del escenario: Ingresar a las secciones principales
    Dado que Juan abre la aplicacion ApiDemos
    Cuando ingresa a la seccion "<seccion>"
    Entonces deberia visualizar la opcion "<opcion>"

    Ejemplos:
      | seccion    | opcion    |
      | App        | Activity  |
      | Animation  | Cloning   |
      | Preference | 9. Switch |

  @navegacion
  Escenario: Regresar al menu principal desde una seccion
    Dado que Juan abre la aplicacion ApiDemos
    Cuando ingresa a la seccion "Animation"
    Entonces deberia visualizar la opcion "Cloning"
    Cuando regresa a la pantalla anterior
    Entonces deberia visualizar la opcion "Preference"


  @preferencias
  Escenario: Configurar una preferencia que depende de otra
    Dado que Juan abre la aplicacion ApiDemos
    Cuando ingresa a la seccion "Preference"
    Y ingresa a la seccion "3. Preference dependencies"
    Entonces la opcion "WiFi settings" deberia estar deshabilitada
    Cuando activa la casilla "WiFi"
    Entonces la opcion "WiFi settings" deberia estar habilitada
    Cuando ingresa a la seccion "WiFi settings"
    Y escribe "RedCibertec" en el campo del dialogo
    Y confirma el dialogo
    Y ingresa a la seccion "WiFi settings"
    Entonces el campo del dialogo deberia contener "RedCibertec"