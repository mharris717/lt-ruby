##Ruby for Light Table

This plugin is an alpha implementation of a ruby in Light Table.  It can evaluate the contents of a ruby file and print the result of the last statement up at the top line.  It can also eval selections of ruby code and print the result next to it.

No extra editing of the file is needed, and the result comes back in the nice Light Table widgets.  Like a true repl eval happens in its own binding so your state will persist across evals.

## Installation

1.  From LightTable's plugin manager, choose the available tab and double-click the "Ruby Instarepl" plugin to install it
2.  If your preferred ruby is not your system default, go to User Behaviors and add an entry for `(:lt.objs.langs.ruby/ruby-exe /path/to/ruby)`
3.  Open the Command Bar and choose `App: Reload Behaviors` or restart LightTable
4.  open up a ruby file, add a "Ruby" connection, select some code and use `ctrl/cmd-enter` to eval it.  Use `ctrl/cmd-shift-enter` to eval the whole file (the result will be added off the first line).

## Requirements

You'll need the `eventmachine` and `json` gems installed.  RVM users should set the path to their preferred ruby executable in `:lt.objs.langs.ruby/ruby-exe`

Developed on Mac OS X 10.7 with ruby 2.0

## The Road Forward
There are plenty of rough edges still.  Exceptions in ruby aren't being properly communicated back to the editor, for example, and there is some pollution between the repl client and the evaluation environment.  When eval'ing multiple statements, it could be nice to see inline results for each statement.

Once I get things working better for vanilla ruby, I plan to add better support for RVM and Rails.

## Acknowledgements

The clojurescript / lighttable side are pretty much simple searches and replaces of the equivalent files from the Python plugin.  Thank you Chris and everyone else at Kodowa for getting me so inspired about a text editor.

###License

Copyright (C) 2013 Rafe Rosen

Distributed under the GPLv3, see license.md for the full text.
