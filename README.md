# spring-boot-gwt-cft
Simple application used Spring as backend and GWT as frontend.

Building: Just enter in your cmd (use gradle 3.1+ and java 1.8):

<pre><code>gradle build</code></pre>

After build you can run application

<pre><code>java -jar build\libs\spring-boot-gwt-1.0.0.jar</code></pre>
Application will be run on <b>localhost:8080</b>

Don't forget to set database profile in the <b>application.properties</b> file:

<pre><code>spring.profiles.active=oracle</code></pre>
or
<pre><code>spring.profiles.active=h2</code></pre>
and edit corresponding properties files <b>application-h2.properties</b> and <b>application-oracle.properties</b> according to your DB settings.

Also you can debug application. First run codeserver in first cmd window with command
<pre><code>gradle gwtSuperDev</code></pre>
Go to the codeserver page <b>localhost:9876</b> and save buttons DevModeOn and DvModeOff to your bookmark.

Next in second cmd window run application
<pre><code>java -jar build\libs\spring-boot-gwt-1.0.0.jar</code></pre>
Now you can open debuger in your browser (usually by F12 key), go to the application page <b>localhost:8080</b> and by click saved button DevModeOn you will be able to debag application

