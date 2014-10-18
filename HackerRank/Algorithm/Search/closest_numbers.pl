#!/usr/bin/perl
use strict;
use warnings;
use Data::Dumper;

sub closest
{
	my %argHash = @_;

	my @array = sort { $a <=> $b } @{$argHash{'array'}};

	my $minDiff = $array[1]-$array[0];
	my @resultsArray = ($array[0] , $array[1]);

	for (2..$#array)
	{
		my $diff = $array[$_] - $array[$_-1] ;
		if($diff < $minDiff)
		{
			$minDiff = $diff ;
			@resultsArray = ($array[$_ -1],$array[$_]);
		}
		elsif($diff == $minDiff)
		{
			push @resultsArray,$array[$_ -1];
			push @resultsArray,$array[$_];
		}
	}

	return "@resultsArray";
}

my $size = <>;
my @array = split(' ',<>);
print closest('array' => \@array);
print "\n";