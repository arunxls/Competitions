#!/usr/bin/perl
use strict;
use warnings;

# Tail starts here
my $element = <>;
my $array_size = <>;
my @array = ();
$/ = ' ';
for (my $i = 0; $i < $array_size; $i++) {
   $array[$i] = int(<>);
}

foreach my $index (0..$#array) {
	print $index if ($array[$index] == $element); 
}