import React from 'react';
import { scaleLinear } from 'd3-scale';
import { select } from 'd3-selection';
import { axisBottom, axisLeft } from 'd3-axis';
import * as d3 from 'd3-selection';

export default function FunctionPlot({ f, width, margin, height, range }) {
    d3.select('svg').selectAll('*').remove();
    margin = margin || 40;
    width = width || 400;
    height = height || 300;
    range = range || { x: [-10, 10], y: [-10, 10] };
    return (
        <svg
            ref={(el) => {
                const svg = select(el)
                        .attr('width', width + 20)
                        .attr('height', height + 20),
                    x = scaleLinear()
                        .domain(range.x)
                        .range([margin, width - margin]),
                    y = scaleLinear()
                        .domain(range.y)
                        .range([height - margin, margin]),
                    g = svg.append('g'),
                    line = [];
                for (let i = margin + 1e-6; i < width - margin; i += 1) {
                    const X = x.invert(i),
                        Y = f(X),
                        j = y(Y);
                    line.push([i, j]);
                }
                g.append('path')
                    .attr('d', 'M' + line.join('L'))
                    .style('stroke', 'steelblue')
                    .style('fill', 'none');
                g.append('g').attr('transform', `translate(${margin},0)`).call(axisLeft(y));
                g.append('g')
                    .attr('transform', `translate(0,${y(0)})`)
                    .call(axisBottom(x));
            }}
        ></svg>
    );
}