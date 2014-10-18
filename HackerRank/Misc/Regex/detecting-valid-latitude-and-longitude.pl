#!/usr/bin/perl
use strict;
use warnings;

sub hacker
{
    my $str = shift;
    my $return = 'Invalid';
    # -90<=X<=+90 and -180<=Y<=180.

    if($str =~ /\([+|-]*([1-9]+\d*[\.\d+]*)\,\s*[+|-]*([1-9]+\d*[\.\d+]*)\)/s){
        unless($1 =~ /\.$/s || $2 =~ /\.$/s) {
            $return = 'Valid'if(($1 >= -90) && ($1 <= 90) && ($2 >= -180) && ($2 <= 180))
        }
    }
    return $return;
}

# Tail starts here
my $testcases = <>;
for (1..$testcases){
    my $str = <>;
    print hacker($str)."\n";
}
