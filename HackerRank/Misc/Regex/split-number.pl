#!/usr/bin/perl
use strict;
use warnings;
use Data::Dumper;

sub split_number
{
	my $num = shift;

	my @array = split(/-|\s/s,$num);

	return "CountryCode=".$array[0].",LocalAreaCode=".$array[1].",Number=".$array[2];
}

# Tail starts here
my $testcases = <>;
for (1..$testcases){
	my $num = <>;
	print split_number($num)."\n";
}