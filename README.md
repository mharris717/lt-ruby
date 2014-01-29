## Ruby Instarepl for Light Table

This plugin is an alpha implementation of a ruby instarepl for the [Light Table](http://www.lighttable.com) IDE.  On demand, it can evaluate the contents of a ruby file and print the result of the last statement at the bottom.  It can also eval selections of ruby code and print the result next to it.

No extra editing of the file is needed, and the result comes back in the nice Light Table widgets.  Like a true repl your state will persist between evals.

There is also a basic Live Mode/Instarepl that will evaluate lines of code as you type (see below).

## Installation

1.  From LightTable's plugin manager, choose the available tab and double-click the "Ruby Instarepl" plugin to install it.
2.  If your preferred ruby is not your system default, go to User Behaviors and add an entry for `:editor.ruby [(:lt.objs.langs.ruby/ruby-exe "/path/to/ruby")]`
3.  Open the Command Bar and choose `App: Reload Behaviors` or restart LightTable
4.  Open up a ruby file, select some code and use `ctrl/cmd-enter` to eval it.  Use `ctrl/cmd-shift-enter` to eval the whole file.

## Requirements

You'll need the `eventmachine`, `json`, and `method_source` gems installed.

Developed on Mac OSX 10.7 with ruby 2.0.  Seems to work OK with REE 1.8 and ruby 1.9.  I have no clue if it works on other platforms.

## Usage

### Evaluating Ruby on Demand

- `ctrl/cmd-shift-enter` evals a whole file and prints the result of the last statement.
- `ctrl/cmd-enter` evals the selected text and prints results inline.  If no text is selected it evals the current line.

If the code sent for evaluation is not a complete statement, then the inline result will show `…` The code will be saved, and any future code sent for evaluation will be concatenated and evaled together.

### Live Mode aka "Instarepl"

A basic live evaluation mode has been implemented.  To enable it for your editor, type `ctrl/cmd-space` and choose `Ruby Instarepl: Toggle live mode`.

When enabled, new lines typed at the end of the file will automatically be sent to the repl process for evaluation.

### Watches
Watches enable you to see the results of individual expressions that were executed as part of an eval.

- `alt-w` adds a watch for the selection
- `alt-shift-w` removes the watch for the selection

At present, you have to re-evaluate the whole file with `ctrl/cmd-shift enter` before your watches will be active.  This will be fixed in a future version (see #14)

### RVM and Rbenv support

Support exists for both RVM and rbenv.  To enable RVM add `:editor.ruby [(:lt.objs.langs.ruby/use-rvm)]` to your User Behaviors.  Once that's in place the ruby repl will be run out of whatever RVM environment you've defined for that directory via rvmrc, etc.

Similarly, to enable rbenv add `:editor.ruby [(:lt.objs.langs.ruby/use-rbenv)]`

### Rails support

As of v0.0.4, the plugin is able to load a Rails environment.  Just start up a Ruby connection in your project directory and then eval `require 'config/environment'`

## The Road Forward
I hope to add more features for Rails in future versions.  Also the live mode could be enhanced to enable automatic watches.

I try to plan out features in the [Wish List](https://github.com/existentialmutt/lt-ruby/issues?labels=Wish+List&page=1&state=open)


## Acknowledgements

The clojurescript / lighttable side started by using the Python plugin as a template.  Thank you Chris and everyone else at Kodowa for getting me so inspired about a text editor.

Thanks also to my employer, [Green River](http://www.greenriver.com) for supporting development of this plugin.

## Changelog

##### 0.0.9

- incomplete eval
- basic live mode
- require `method_source` gem

##### 0.0.8

- implemented watches
- moved result of whole-file eval down to the bottom
- `ctrl/cmd-enter` evals current line if no selection

##### 0.0.7

- fix for issue #12: reporting exceptions from whole-file eval.
- `__FILE__` now gets set correctly
- exceptions get correct line numbers in stack trace

##### 0.0.6

- rbenv support
- Changed RVM support behavior from `:editor.ruby [(:lt.objs.langs.ruby/use-rvm? true)]` to `:editor.ruby [(:lt.objs.langs.ruby/use-rvm)]` to better match style of other boolean behaviors.

##### 0.0.5

- resyncing tag version w/ version in plugin.json

##### 0.0.4

- Basic rails loading via eval.

##### 0.0.3

- added support for loading an rvm environment.

##### 0.0.2

- Numerous bugfixes and general less-janky-making.  You no longer to need to manually create the connection (just select some code and eval).

#####  0.0.1

- Initial release with eval for whole files and selections

###License

Copyright (C) 2014 Rafe Rosen

Distributed under the GPLv3, see license.md for the full text.
