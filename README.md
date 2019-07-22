# Ud3_Ejemplo8
_Ejemplo 8 de la Unidad 3._ 

Vamos a insertar un menú (ActionBar) en una actividad. Este menú tendrá dos elementos (uno de ellos con icono) y un submenú. Al pulsar
 algún elemento del menú aparecerá un mensaje por pantalla.

Para ello tenemos que seguir los siguientes pasos:

## Paso 1: Creación del menú

Primero creamos un nuevo directorio llamado _menu_ dentro del directorio _res_. Dentro de él creamos un nuevo _Menu resource file_ 
llamado _menu_main.xml_ con el siguiente contenido:
```
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <item android:id="@+id/elem1"
        android:title="@string/elemento1"
        android:icon="@drawable/estrella"
        app:showAsAction="always">
    </item>
    <item android:id="@+id/elem2"
        android:title="@string/elemento2"
        app:showAsAction="never">
    </item>
    <item android:id="@+id/submenu"
        android:title="@string/submenu"
        app:showAsAction="never">
        <menu>
            <item android:id="@+id/elem3"
                android:title="@string/elemento3" />
        </menu>
    </item>
</menu>
```
Podemos ver que por cada elemento se usa la etiqueta _item_ y para el submenú la etiqueta _menu_ y por cada subelemento _item_.
Usamos el atributo _showAsAction_ para indicar si se mostrará o no el elemento. Si le especificamos _never_ el elemento está oculto 
dentro de un icono de 3 puntos verticales.

Por su parte, el fichero _activity_main.xml_ en este caso será el creado por defecto:
```
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>
```

## Paso 2: Modificación de la actividad

El siguiente paso es sobrescribir en la clase _MainActivity_ los métodos _onCreateOptionsMenu_ para "inflar" el menú y _onOptionsItemSelected_ para detectar qué 
elemento del menú se ha pulsado haciendo uso del método _getItemId_:
```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // "Inflamos" el menú diseñado
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Dependiendo del elemento pulsado hacemos una acción u otra.
        switch(item.getItemId()){
            case R.id.elem1:
                Toast.makeText(this, "Elemento1", Toast.LENGTH_LONG).show();
                return true;
            case R.id.elem2:
                Toast.makeText(this, "Elemento2", Toast.LENGTH_LONG).show();
                return true;
            case R.id.elem3:
                Toast.makeText(this, "Elemento3", Toast.LENGTH_LONG).show();
                return true;
        }

        return super.onContextItemSelected(item);
    }
}
```
