#!/usr/bin/perl
use strict;
use warnings;
use Data::Dumper;

sub min_toys
{
	my %argHash = @_;

	my @array = sort { $a <=> $b }  @{$argHash{'array'}};
	my $num = $argHash{'num'};
	my $count = 0;

	for (0..$#array)
	{
		$count += $array[$_];		
		return $_  if ($count > $num);
	}
}

my ($size,$num) = split(' ',<>);
my @array = split(' ',<>);
print min_toys('array' => \@array, 'num' => $num);
