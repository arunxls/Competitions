#!/usr/bin/perl
use strict;
use warnings;
use Data::Dumper;

sub lonely_number
{
	my %argHash = @_;

	my @array = @{$argHash{'array'}};

	my %numHash = ();

	for (@array)
	{
		if (exists $numHash{$_})
		{
			delete $numHash{$_}
		}
		else
		{
			$numHash{$_} = 1;
		}
	}

	return keys %numHash;
}

my $size = <>;
my @array = split(' ',<>);
print lonely_number('array' => \@array);
print "\n";