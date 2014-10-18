#!/usr/bin/perl
use strict;
# use warnings;

sub match
{
    my $string = shift;

    foreach my $str (split(/\n/,$string)) {
        if($str =~ /<h3><a href="\/questions\/(\d+)+.*">(.+)+<\/a><\/h3>/s){
            print "$1;$2;";
        }

        if($str =~ /asked.*>(.+)+<\/span>/s) {
            print "$1\n";
        }
    }
}

# Tail starts here
my $str = do { local $/; <STDIN> };
print match($str);
