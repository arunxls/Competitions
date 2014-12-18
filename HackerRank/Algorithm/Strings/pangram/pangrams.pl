#!/usr/bin/perl
use strict;
use warnings;
use Data::Dumper;

# https://www.hackerrank.com/challenges/pangrams

# Head ends here

my $hash = {};

sub pangram {
    my $string = shift;
    foreach my $s (split('',$string)) {
        if ($s =~ /\w/i) {
            $hash->{lc $s} = 1;
        }

        if (scalar keys %{$hash} == 26) {
            print "pangram\n";
            return;
        }
    }
    print "not pangram\n";
    return;
}

#Tail starts here
my $input = <>;
chomp $input;
pangram($input);
