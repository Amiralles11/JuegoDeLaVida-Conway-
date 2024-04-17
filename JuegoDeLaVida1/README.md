Práctica Final: Simulador de Poblaciones


El juego de la vida de Conway es un problema muy usado en computación para mostrar el
comportamiento de una población de autómatas celulares, pero no deja de ser un pequeño juego
matemático con condiciones simples de evolución. La práctica propone la programación de un
simulador de poblaciones de individuos que evolucionan en el tiempo en un mundo con recursos
que aparecen y desaparecen, mostrando todo en una interfaz gráfica visual, divergiendo
notablemente de los elementos del juevo de la vida de Conway desde el punto de vista práctico.


Para ello, existen 3 grandes elementos: el tablero de juego, donde se desarrollará la acción y donde
aparecerá la información del juego, los individuos que irán evolucionando en el juego, y los
recursos que permiten a los individuos “vivir”.


Existen varios requisitos básicos a cumplir:
• El usuario debe poder parametrizar los distintos elementos a través de las correspondientes
ventanas/pantallas/tabs.
• El usuario debe poder establecer en el tablero de juego las condiciones iniciales del mismo:
dónde estarán los recursos inicialmente, dónde estarán los individuos inicialmente, etc.
• El usuario debe poder pausar la simulación, pudiendo en ese caso alterar el juego
estableciendo y/o cambiando qué recursos aparecen dónde, y añadiendo o quitando
individuos que respetarán los parámetros que en ese momento estén activos.
• Los datos del juego deben poder guardarse a archivo/s, y deben poder volver a cargarse.


Tablero de juego:
El tablero de juego es una matriz, de NxM posiciones.
Los individuos y los recursos ocupan una posición de la matriz.
Una posición de la matriz puede tener 3 recursos y como máximo 3 individuos a la vez. Si en algún
momento existen más de 3 individuos en una celda, aquellos con menor números de turnos de vida
que les queden morirán hasta llegar a quedar los 3 individuos.


Individuos:
Los individuos del juego ocupan una única casilla, y tienen como parámetros:
• Identificación del individuo: un número único que identifica al individuo.
• Generación del individuo: Se obtiene según el turno en el que se creó.
• Turnos de vida que le quedan: Número de turnos donde se puede seguir desarrollando.
• Probabilidad de reproducción: Si 2 individuos ocupan la misma posición de la matriz, o se
reproducen generando otro individuo más, o mueren ambos.
• Probabilidad de clonación. En cada paso, un individuo puede clonarse a sí mismo, y el clon
aparecerá en la misma posición del mapa. 
• Probabilidad de muerte = (1-Probabilidad de reproducción).
Los valores iniciales del “individuo tipo” deben ser parametrizables para la partida. 

Tendremos 3 tipos de individuos:
1. Tipo básico: se mueve aleatoriamente.
2. Tipo normal: se mueve en línea recta hacia un recurso del entorno (seleccionado
   aleatoriamente de los disponibles).
3. Tipo avanzado: es capaz de hacer rutas hacia la posición de los recursos y seleccionar el
   recurso al que quiere ir (el más cercano que no esté en la posición actual del individuo).
   Sobre los individuos y la reproducción:• La reproducción de dos individuos del mismo tipo da lugar a otro individuo de ese tipo.
   
• La reproducción de individuos de distinto tipo da lugar a otro individuo del tipo más alto en
   un porcentaje X de mejora de población del juego.
   En cada turno, el individuo será modificado de la siguiente manera:
   La vida baja 1 turno.
   La probabilidad de reproducción baja un 10% de lo que tenga en ese momento el individuo.
   La probabilidad de mutación baja un 10% de lo que tenga en ese momento el individuo.
   En un turno un individuo DEBE moverse.
   

Entorno
   El entorno modela cómo los recursos que hay en él permiten que un individuo pueda alterar los
   valores de sus parámetros. El entorno está asociado a posiciones estáticas del tablero de juego.
   Tendremos 6 tipos de elementos de entorno (como mínimo).
1. Agua
2. Comida
3. Montaña
4. Tesoro
5. Biblioteca
6. Pozo
   Para simular un entorno en evolución, cada elemento del entorno tiene un tiempo de aparición en el
   que estará activo y visible en el mapa. Cada posición del mapa puede tener un máximo de 3
   recursos en un momento determinado: Si una posición tiene menos de 3 recursos, en cada turno
   puede aparecer uno nuevo con probabilidad Z, parametrizable para cada recurso con probabilidad V,
   ajustable en cada partida.
   (Ejemplo: en el turno 3 la posición (4,5) tiene un recurso Agua, con un tiempo de aparición de 3. En
   ese turno se evalúa si puede aparecer un nuevo recurso, a elegir entre los 6 posibles. El cálculo
   usará la probabilidad Z para saber si debe aparecer o no un nuevo recurso, y si el resultado es
   positivo, entonces se usarán las probabilidades V de cada tipo de recurso para elegir aquel que
   aparecerá finalmente.)
   Estos elementos del entorno harán de modificadores a los parámetros del individuo:
   Por ejemplo, el Agua sumará 2 turnos de vida al individuo, la Comida 10 turnos de vida, y la
   Montaña disminuirá 2 turnos de vida, el Tesoro aumentará la probabilidad de reproducción del
   individuo un X%, mientras que la Biblioteca aumentará la probabilidad de clonación un Y% y
   aumentará el tipo del individuo, siendo el Pozo la muerte instantánea.
   Todos los valores deben ser parametrizables para la partida.
   Bucle de control:
   

El bucle de control realizará las operaciones del juego en orden:
1. Para cada individuo, se actualiza su tiempo de vida, y en su caso se elimina si ha muerto.
2. Para cada recurso, evaluará si sigue activo o debe eliminarse (por su tiempo de aparición).
3. Se ejecutará el movimiento de cada individuo (siempre obligatorio).
4. Para cada individuo evaluará las mejoras obtenidas por los distintos recursos que se
   encuentren en su nueva posición.
5. Para cada posición, evaluará si existe reproducción o no.
6. Para cada individuo, evaluará si existe clonación o no.7. Para cada posición del tablero en la que existan varios individuos, se evaluará si deben
   desaparecer algunos.
8. Para cada posición del tablero, se evaluará si deben aparecer nuevos recursos.
   Condición de finalización:
   Sólo queda un individuo vivo ó el usuario decide finalizar la simulación.
   Tras la partida:
   Debe mostrarse el árbol de reproducción del elemento/s ganador/es (si existen tales elementos),
   mostrando su árbol genealógico.
   Elementos evaluables del trabajo:
   

Metodología de la programación:
   • Se pide el análisis y diseño del programa indicado, mostrando el diagrama de clases
   correspondiente y los diagramas de secuencia que ilustran las operaciones a realizar en
   UML, y desarrollando una breve memoria explicativa de cómo se han realizado y cómo
   cubren las necesidades expuestas en este enunciado.
   ◦ Pista: divide y vencerás, analiza cada sección del problema, genera una lista de
   requisitos identificados unívocamente, establece módulos, clases y las interacciones
   entre ellas: describe el proceso, y haz una matriz que diga qué método de qué clase se
   encarga de cada requisito que has establecido.
   • Se debe programar una interfaz gráfica para el juego:
   ◦ Habrá un menú principal con las opciones:
   ▪ Nuevo juego
   ▪ Cargar juego
   ◦ Habrá una pantalla de configuración donde, mediante tabs, se puedan ajustar los
   parámetros del juego usando sliders.
   ◦ Habrá una pantalla de juego donde aparecerá el tablero, y en cada posición la
   información de qué hay en el mismo. La visualización de cada celda se deja a criterio del
   alumno. Si se pulsa sobre una celda, aparecerá la información desglosada de los
   elementos de la celda. En la pantalla aparecerá el turno que se está ejecutando.
   ▪ Se debe poder tener control de la ejecución del juego: play, pause, stop.
   ▪ En la pantalla de juego se podrá acceder a la configuración siempre que el juego esté
   en pause.
   ▪ En la pantalla de juego, si el juego está en pause, se podrá guardar el estado actual
   del juego en ficheros para poder ser cargado otra vez desde el menú principal.
   • Se debe poder parametrizar los elementos del juego antes y durante el mismo.
   • Todas las clases que no son de visualización deben tener sus tests unitarios.
   • Deben usarse las excepciones del sistema, y crear nuevas si es necesario, para cubrir los
   casos de error.
   • Se deben usar logs del sistema para poder mostrar las operaciones que se están realizando en
   el programa, de manera detallada.
   • Se debe almacenar todo el código y ejemplos en un repositorio GIT.
   

Estructuras de datos:
   • Está prohibido usar estructuras de árboles (listas, árboles, grafos, etc.) que no sean originales
   de los alumnos.• Se evaluarán las estructuras utilizadas, así como su adecuación al problema del enunciado.
   • Se evaluará que TODOS los elementos sean dinámicos: p.ej. allí donde se dice que una
   celda tiene 3 elementos como máximo, se desea que “mañana” pueda cambiar a N
   elementos sin afectar al código.
   • El programa mostrará los árboles genealógicos de los individuos, manteniéndolos según se
   necesite.
   • El programa guardará una cola con las operaciones realizadas por cada individuo.
   • El programa, en su finalización, construirá un grafo en base a las colas de cada individuo,
   con las operaciones realizadas en el global de la partida.
   • Se realizará un recorrido del grafo buscando ciclos, mostrando información sobre la
   caracterización del grafo.
   • ¿Qué individuo ha sido el más longevo? ¿Qué ha hecho?
   • ¿Cuántas mutaciones ha habido?
   • ¿Cuántas reproducciones ha habido?
   • ¿Qué individuo ha tenido más reproducciones?
   • ¿Qué individuo ha tenido más mutaciones?
   • ¿Qué individuo ha bebido más agua?
   • ¿Qué individuo ha conseguido llegar a un momento de máximo tiempo de vida disponible?
   ¿Cuánto ha sido? ¿Coincide con el más longevo?
   • Deben entregarse los diagramas UML correspondientes a las clases realizadas, tanto de
   clases como de secuencia para las operaciones que los alumnos consideren relevantes.
   

Entregables:
1. Debe entregarse una memoria con la documentación descriptiva del trabajo realizado. En la
   documentación se adjuntarán los trabajos de análisis, diseño y diagramas realizados. Debe
   diferenciarse entre la parte de Metodología de la Programación y la parte de Estructuras de
   datos (Se realizará doble entrega, una en cada asignatura).
2. Debe entregarse el código funcional en un repositorio de GIT.
3. Debe entregarse en la plataforma BlackBoard un vídeo de defensa del trabajo realizado de
   no más de 100Mb, donde aparezcan los alumnos del grupo en webcam explicando la
   práctica y mostrando su funcionamiento. (OBLIGATORIO QUE LA ENTREGA SEA EN
   BLACKBOARD, no se admitirán entregas en otras plataformas). Si el vídeo ocupa más de
   100Mb, deberá se partido en varias partes, y subidas cada una de ellas. (Se recomienda usar
   OBS para la grabación, y winrar para partir el vídeo en ficheros de menos de 100Mb).
   No completar estos entregables con lo solicitado en la práctica tendrá asociada la calificación de 0
   puntos.