#!/usr/bin/perl
use strict;
use warnings;

my %lan = (
    'C'             => '',
    'CPP'           => '',
    'JAVA'          => '',
    'PYTHON'        => '',
    'PERL'          => '',
    'PHP'           => '',
    'RUBY'          => '',
    'CSHARP'        => '',
    'HASKELL'       => '',
    'CLOJURE'       => '',
    'BASH'          => '',
    'SCALA'         => '',
    'ERLANG'        => '',
    'CLISP'         => '',
    'LUA'           => '',
    'BRAINFUCK'     => '',
    'JAVASCRIPT'    => '',
    'GO'            => '',
    'D'             => '',
    'OCAML'         => '',
    'R'             => '',
    'PASCAL'        => '',
    'SBCL'          => '',
    'DART'          => '',
    'GROOVY'        => '',
    'OBJECTIVEC'    => '',
);

sub match
{
    my $str = shift;

    if($str =~ /\s([A-Z]+)+$/){
        return "VALID" if(defined $lan{$1});
    }
    return "INVALID";
}


# Tail starts here
my $testcases = <>;
for (1..$testcases){
    my $str = <>;
    chomp($str);
    print match($str)."\n";
}