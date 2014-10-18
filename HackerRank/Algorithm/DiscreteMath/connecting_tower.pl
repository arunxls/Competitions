#!/usr/bin/perl
use strict;
use warnings;

sub routes
{
	my ($tower,$routes) = @_;

	my $output = 1;
	map { $output = $output*$_} split(' ',$routes);
	return ($output%1234567)
}

#Tail starts here
my $test_cases = <>;
for (my $index = 0; $index < $test_cases; $index++)
{
    my $keyword = <>;
    chomp $keyword;
    my $input = <>;
    chomp $input;
	print routes($keyword,$input);
	print "\n";
}