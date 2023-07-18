1. Ein Software-Entwurfsmuster ist eine
allgemeine, wiederverwendbare Lösung für ein häufig auftretendes
Problem in einem bestimmten Kontext des Softwareentwurfs.
Die Struktur kann in Form ein UML angezeigt und dabei werden verschiedene 
komponenten des Entwurfsmusters und ihre Beziehungen zueinander beschrieben.
2. Ein AntiPattern ist ein Muster, das beschreibt, wie
   wie man von einem **Problem** zu einer schlechten **Lösung** kommt
    1. Das "Goldene Hammer" Anti Pattern: Hierbei wird eine einzige Lösung
        für alle möglichen Probleme eingesetzt, ohne die Anforderung und Eigenschaften
   des Problems angemessen zu berücksichtigen.
   2. Das "Big Ball of Mud " Anti Pattern: In diesen Fall wird der Code
   ohne klare Struktur und Architektur entwickelt. Es gibt keine klare
   Trennungen von Verantwortlichkeit oder schichten, was zu einem chaotischen
    und schwer wartbaren System führt.
   3. Das "Magic Pushbutton" Anti Pattern: Hier wird eine Technologie, ein 
   Framework oder ein Werkzeug als Allheilmittel betrachtet, das automatisch alle 
   Probleme löst. Dies führt zu einer übermäßigen Abhängigkeit von diesen Werzeug und 
   magelnder Berücksichtigung der zugrunde liegenden Prinzipien und 
   konzepte.

3. Singleton Design Pattern: Stellt sicher, dass von einer Klasse jeweils
**nur eine Instanz** existiert, um auf einen globalen Zugriffspunkt auf
eine einzige Instanz zugegriffen werden muss.
      **Vorteile:**
    1. Singleton ermöglicht den Zugriff auf eine einzige Intanz einer klasse, 
   was in einigen Situationen nützliich sein kann.
   2. Durch den globalen Zugriff kann auf die Instanz von überall im Code 
   aus zugegriffen werden.
   3. Singleton kann eine zentrale Schnittstelle für bestimmte Funktionalität 
   bereitstellen.
   **Nachteile**
   1. Ein Sigleton kann schwer zu testen sein, da er stark gekoppelt ist und globalen
   Zustand verwendet. Das erschwert das Testen der Komponenten 
   2. Singleton-Instanzen können schwer zu verwalten sein, wenn sie in einer 
   mehrstufigen Anwendung verwendet werden. 
   3. Kann die Skalierbarkeit beeinträchtigen, da er nur eine einzige 
   Instanz zulässt. Zb wenn mehere Instanzen benötigt wird, muss das 
   pattern Singleton umgeschrieben werden.

4. Hier wird bei der Structural Design Pattern das **"Decorator"** verwendet
und die neue Funktionalitäten zu verketten bzw hinzufügen.