# cloud-itonami-assoc-9411-arg-uia

Industry rule/history catalog for the **Unión Industrial Argentina**
(UIA) — the FIFTEENTH entry aligned to **ISIC 9411** (activities of
business, employers, and professional membership organizations),
alongside
[`-9411-sau-fsc`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-sau-fsc)
(Saudi Arabia),
[`-9411-aut-wko`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-aut-wko)
(Austria),
[`-9411-irl-ibec`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-irl-ibec)
(Ireland),
[`-9411-nzl-businessnz`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-nzl-businessnz)
(New Zealand),
[`-9411-cze-spcr`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-cze-spcr)
(Czech Republic),
[`-9411-ind-cii`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-ind-cii)
(India),
[`-9411-zaf-busa`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-zaf-busa)
(South Africa),
[`-9411-bra-cni`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-bra-cni)
(Brazil),
[`-9411-ken-kam`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-ken-kam)
(Kenya),
[`-9411-can-chamber`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-can-chamber)
(Canada),
[`-9411-mex-coparmex`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-mex-coparmex)
(Mexico),
[`-9411-ita-confindustria`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-ita-confindustria)
(Italy),
[`-9411-nld-vnoncw`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-nld-vnoncw)
(Netherlands), and
[`-9411-kor-kcci`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-kor-kcci)
(South Korea). Part of the
[`cloud-itonami`](https://github.com/cloud-itonami) compliance-fact
family (ADR-2607141700, `cloud-itonami-compliance-fact-federation`,
in `com-junkawasaki/root`).

## Sourcing note

This repo fills Argentina's previously-open association-axis gap
(one of the 13-country gap list recorded at tick 149). Argentina now
has real, individually verified facts across all three axes: country
([`cloud-itonami-iso3166-arg`](https://github.com/cloud-itonami/cloud-itonami-iso3166-arg)),
municipality
([`cloud-itonami-municipality-arg-buenos-aires`](https://github.com/cloud-itonami/cloud-itonami-municipality-arg-buenos-aires)),
and association (this repo).

23 entries, each carrying the page it came from (`:source-article`)
and the verbatim Spanish span it rests on (`:source-quote`). 21 are
UIA's own pages on `uia.org.ar` (¿Qué es la UIA?, Departamentos and
eight department pages, the CEU page, the Día de la Industria agenda
page, and seven dated Novedades posts). The 7 February 1887 founding
day is cited from the Argentine government's own note on
`argentina.gob.ar`, whose first sentence names it. The 27 September
1913 first headquarters is cited from `es.wikipedia.org`, a secondary
source named as one (`:wikipedia-es`).

The July citation for the founding date,
`uia.org.ar/general/2467/130-anos-trabajando-por-el-desarrollo-industrial/`,
answers **404** since UIA rebuilt its site (measured 2026-09-25 UTC),
so it is no longer cited. The live site gives the founding only as a
year ("Desde 1887"), and that is recorded at year precision.

No personal names of office-holders are persisted. The quotes stop
before each name, and `test/association/facts_test.kotoba` pins that
they still do.

**A rejected source error**: a separate `uia.org.ar` page claims a
predecessor organization was founded in "1785" — historically
implausible (it predates Argentina's own 1816 independence) and
contradicted by secondary sources placing this predecessor's founding
around 1875. Rather than propagate a directly-quoted but clearly
erroneous primary-source date, this claim was checked, found
implausible, and deliberately excluded from `catalog` rather than
"fabricated around" with a guessed correction.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on UIA's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `data/datascript-tx.edn` — the catalog. The facts are authored here
  and nowhere else.
- `src/association/facts.kotoba`, `src/association_facts.kotoba` —
  the Clojure and Kotoba readings, **generated** from the data file by
  `scripts/gen-kotoba-port.cljk`. Do not hand-edit them.
- `schema/association-rule.edn` — DataScript schema.

Check it:

```sh
kbb --backend sci scripts/gen-kotoba-port.cljk --check    # both readings match the data file
kbb --backend sci scripts/verify-catalog.cljk             # structural, offline
kbb --backend sci scripts/verify-catalog.cljk --live      # fetch every :url, require every quote
```

`verify-catalog` exits 0 (checked, nothing wrong), 1 (findings
printed), or 2 (refused: it could not read the catalog or a source,
so this is neither a pass nor a finding). `--live` needs `curl` on
PATH. It prints `FETCHED n/n` and one `CONTROL` line per host for a
path that cannot exist, so that a soft-404 fallback page is detected
instead of being read as support.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Policy text
itself remains UIA's; this repo stores only citation metadata
(id/title/url/dates), not full text.
